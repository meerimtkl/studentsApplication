package kg.megacom.students1.controllers;

import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.dto.CourseDto;
import kg.megacom.students1.services.CourseService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
@PostMapping("/create")
    public CourseDto createCourse(@RequestBody Course course){ return courseService.createCourse(course);    }
    @GetMapping("/all")
    public List<CourseDto>findAll(){return courseService.findAll();}
    @PutMapping("/update")
    public Course updateCourse(@RequestParam Long id,@RequestParam String title){return courseService.updateCourse(id,title);}

    @DeleteMapping("/delete")
    public void deleteCourse(@RequestParam Long id){courseService.deleteCourse(id);}


}
