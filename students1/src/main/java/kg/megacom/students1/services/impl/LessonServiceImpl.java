package kg.megacom.students1.services.impl;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.megacom.students1.mappers.LessonMapper;
import kg.megacom.students1.models.Lesson;
import kg.megacom.students1.models.Teacher;
import kg.megacom.students1.models.dto.LessonDto;
import kg.megacom.students1.repositories.LessonRepo;
import kg.megacom.students1.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    LessonRepo lessonRepo;
private  final LessonMapper lessonMapper;

    public LessonServiceImpl(LessonMapper lessonMapper) {
        this.lessonMapper = lessonMapper;
    }

    @Override
    public LessonDto createLesson(Lesson lesson) {
         lessonRepo.save(lesson);
         return lessonMapper.toDto(lesson);

    }

    @Override
    public List<LessonDto> findAll() {
        List<Lesson> lessonDtoList=lessonRepo.findAll();
        return lessonMapper.toDtoList(lessonDtoList);

    }

    @Override
    public Lesson updateLesson(Long id,   @DateTimeFormat(pattern="dd-MM-yyyy") Date day) {
        lessonRepo.update(id,day);
        return lessonRepo.findById(id).get();


      //  Optional<Teacher> teacher=teacherRepo.findById(id);
       // teacher.get().setTitle(title);
     //   return teacherRepo.save(teacher.get());
    }

    @Override
    public void deleteLesson(Long id) {
       lessonRepo.delete(lessonRepo.findById(id).get());
    }
}
