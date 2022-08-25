package kg.megacom.students1.services;

import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.dto.StudentDto;
import java.util.List;

import org.springframework.stereotype.Service;


public interface StudentService {
    StudentDto createStudent(Student student);
    List<StudentDto> findAll();

  //   Student update(Long id,String title);

  //  Student delete(Long id);
   /// List<Student> findAllNotDeleted();

}
