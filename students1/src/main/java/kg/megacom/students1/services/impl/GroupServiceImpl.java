package kg.megacom.students1.services.impl;

import kg.megacom.students1.mappers.GroupMapper;
import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.Lesson;
import kg.megacom.students1.models.dto.GroupDto;
import kg.megacom.students1.models.enums.Day;
import kg.megacom.students1.models.requests.GroupRequest;
import kg.megacom.students1.repositories.GroupRepo;
import kg.megacom.students1.repositories.LessonRepo;
import kg.megacom.students1.services.CourseService;
import kg.megacom.students1.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private final GroupRepo groupRepo;

    private final CourseService courseService;
    private final LessonRepo lessonRepo;
    @Autowired
    GroupMapper groupMapper;

    public GroupServiceImpl(CourseService courseService, LessonRepo lessonRepo, GroupRepo groupRepo) {
        this.courseService = courseService;
        this.lessonRepo = lessonRepo;
        this.groupRepo = groupRepo;
    }

    @Override
    public GroupDto createGroup(Group group) {
        //   Course c = courseRepo.getReferenceById(group.getCourse().getCourse_id());
        // group.setCourse(c);
        groupRepo.save(group);


        return groupMapper.toDto(group);


    }
    //НАЙТИ КУРС ПО ID
    //duration не должно быть пустой или  меньше или равно 0

    @Override
    public List<GroupDto> findAll() {
        List<Group> groupDtoList = groupRepo.findAll();

        return groupMapper.toDtoList(groupDtoList);
    }

    @Override
    public Group updateGroup(Long id, String name) {
        return null;
    }

    @Override
    public void deleteGroup(Long id) {

    }

    @Override
    public Group create(GroupRequest groupRequest) {
        //GroupRequest(groupTitle=Java 18:00, courseId=1, startDate=Thu Sep 01 06:00:00 ALMT 2022, days=[MONDAY, WEDNESDAY, FRIDAY])

        // Найти курс по ID
        // duration не должен быть пустой или меньше или равно 0
        // Получить список дат уроков
        // insert into groups
        // insert into lessons
      Course course = courseService.findById(groupRequest.getCourseId());
        System.out.println(course);
        if (course.getDuration() <= 0)
            throw new RuntimeException("Длительность не может быть меньше или равно нулю!");
        List<Date> lessonDates = getLessonsDates(groupRequest.getDays(), course.getDuration(), groupRequest.getStartDate());
        Date maxDate = lessonDates
                .stream()
                .max((a, b) -> (a.compareTo(b)))
                .get();
        Group group = new Group();
        group.setCourse(course);
        group.setStartDate(groupRequest.getStartDate());
        group.setEndDate(maxDate);
        group.setName(groupRequest.getGroupTitle());
        group = groupRepo.save(group);


        Group finalGroup = group;

        List<Lesson> lessons = lessonDates
                .stream()
                .map(x -> {
                    Lesson lesson = new Lesson();
                    lesson.setDay(x);
                    lesson.setGroup(finalGroup);
                    return lesson;

                })
                .collect(Collectors.toList());
        lessonRepo.saveAll(lessons);
        return group;

    }

    private List<Date> getLessonsDates(List<Day> days, int duration, Date startDate) {
        List<Date> dates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        //days=[MONDAY, WEDNESDAY, FRIDAY]
        // [2, 4, 6]
        // []
        for (int i = 0; i < duration; ) {
            long count = days
                    .stream()
                    .map(x -> x.getDayValue())
                    .filter(x -> x == calendar.get(Calendar.DAY_OF_WEEK))
                    .count();
            if (count == 1) {
                i++;
                dates.add(calendar.getTime());
            }
            calendar.add(Calendar.DAY_OF_MONTH, 1);

        }
        return dates;
    }


}
