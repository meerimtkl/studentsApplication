package kg.megacom.students1.controllers;

import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.dto.StudentDto;
import kg.megacom.students1.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/create")
    public StudentDto createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
 @GetMapping("/all")
    public List<StudentDto> findAll(){return studentService.findAll();}
    @PutMapping("/update")
    public Student updateStudent(@RequestParam Long id,@RequestParam String title){
      return studentService.update(id,title);

 }

  @DeleteMapping("/delete")
 Student delete(@RequestParam Long id){
      return studentService.delete(id);

  }

  @GetMapping("/findAllNotDeleted")
 public List<Student>findAllNotDeleted(){return studentService.findAllNotDeleted();}
}
