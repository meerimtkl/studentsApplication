package kg.megacom.students1.services.impl;

import kg.megacom.students1.mappers.CourseMapper;
import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.dto.CourseDto;
import kg.megacom.students1.repositories.CourseRepo;
import kg.megacom.students1.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
@Autowired
CourseRepo courseRepo;

private  final CourseMapper courseMapper;

    public CourseServiceImpl(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    @Override
    public CourseDto createCourse(Course course) {

        courseRepo.save(course);
        return courseMapper.toDto(course);



    }

    @Override
    public List<CourseDto> findAll() {
        List<Course>courseDtoList=courseRepo.findAll();

        return courseMapper.toDtoList(courseDtoList);
    }

    @Override
    public Course updateCourse(Long id, String title) {
        //  Optional<Teacher> teacher=teacherRepo.findById(id);
        // teacher.get().setTitle(title);
        //   return teacherRepo.save(teacher.get());
        Optional<Course>course=courseRepo.findById(id);
        course.get().setTitle(title);
        return courseRepo.save(course.get());
    }

    @Override
    public void deleteCourse(Long id) {
      courseRepo.delete(courseRepo.findById(id).get());
    }

    @Override
    public Course findById(Long id) {
        return courseRepo.findById(id).orElseThrow();

    }
}
