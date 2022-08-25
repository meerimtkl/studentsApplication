package kg.megacom.students1.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.megacom.students1.models.Lesson;
import kg.megacom.students1.models.dto.LessonDto;
import kg.megacom.students1.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("lesson")
public class LessonController {

    @Autowired
    LessonService lessonService;
    @PostMapping("/create")
    public LessonDto createLesson(@RequestBody Lesson lesson){
        return lessonService.createLesson(lesson);
    }
@PutMapping("/update")
    public Lesson updateLesson(@RequestParam Long id,@RequestParam   @DateTimeFormat(pattern="dd-MM-yyyy") Date day){return lessonService.updateLesson(id,day);}
@DeleteMapping("/delete")
    public void deleteLesson(@RequestParam Long id){lessonService.deleteLesson(id);}
    @GetMapping("/all")
    public List<LessonDto> findAll(){return lessonService.findAll();}
}
