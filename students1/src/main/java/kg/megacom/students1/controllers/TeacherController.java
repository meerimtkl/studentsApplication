package kg.megacom.students1.controllers;


import kg.megacom.students1.models.Teacher;
import kg.megacom.students1.models.dto.TeacherDto;
import kg.megacom.students1.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;


    @PostMapping("/create")
    public TeacherDto createTeacher(@RequestBody Teacher teacher) {
        return teacherService.createTeacher(teacher);
    }

    @GetMapping("/all")
    public List<TeacherDto> findAll() {
        return teacherService.findAll();
    }

    @PutMapping("/update")
    public Teacher updateTeacher(@RequestParam Long id, @RequestParam String title) {
        return teacherService.updateTeacher(id, title);
    }

    @DeleteMapping("/delete")
    public void deleteTeacher(@RequestParam Long id) {
        teacherService.deleteTeacher(id);
    }


}
