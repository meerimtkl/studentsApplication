package kg.megacom.students1.services;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.megacom.students1.models.Lesson;
import kg.megacom.students1.models.dto.LessonDto;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public interface LessonService {
    LessonDto createLesson(Lesson lesson);
    List<LessonDto>findAll();

    Lesson updateLesson(Long id,    @DateTimeFormat(pattern="dd-MM-yyyy")Date day);
  void deleteLesson(Long id);
}
