package kg.megacom.students1.services;

import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.dto.CourseDto;
import java.util.List;

public interface CourseService {
    CourseDto createCourse(Course course);
    List<CourseDto> findAll();
    Course updateCourse (Long id,String title);
    public void deleteCourse(Long id);
Course findById(Long id);

}
