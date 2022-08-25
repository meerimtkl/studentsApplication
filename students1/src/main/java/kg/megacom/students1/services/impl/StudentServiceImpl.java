package kg.megacom.students1.services.impl;

import kg.megacom.students1.mappers.StudentMapper;
import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.dto.StudentDto;
import kg.megacom.students1.repositories.StudentRepo;
import kg.megacom.students1.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;

    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    //public StudentServiceImpl(StudentRepo studentRepo){this.studentRepo =studentRepo;}
    @Override
    public StudentDto createStudent(Student student) {
        studentRepo.save(student);

        return studentMapper.toDto(student);

    }

    @Override
    public List<StudentDto> findAll() {
        List<Student> studentList = studentRepo.findAll();

        return studentMapper.toDtoList(studentList);


    }
/*
    @Override
    public Student update(Long id, String title) {
        //Optional<Student> student=  studentRepo.findById(id);
//  student.get().setTitle(title);
//   return studentRepo.save(student.get());
        studentRepo.update(id, title);

return studentRepo.findById(id).get();
    }
*/
    /*@Override
    public Student delete(Long id){
    //    studentRepo.deleteById(id);
    //return studentRepo.findById(id).get();

   // studentRepo.delete(studentRepo.findById(id).get());

        Student student=studentRepo.findById(id).get();
      //  student.setDeleted(true);
        studentRepo.save(student);
        return studentRepo.findById(id).get();

    }*/

//    @Override
//    public List<Student> findAllNotDeleted() {
//        return studentRepo.findAllByIsDeletedIsFalse();
//    }
}
