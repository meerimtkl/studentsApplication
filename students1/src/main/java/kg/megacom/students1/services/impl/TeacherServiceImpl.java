package kg.megacom.students1.services.impl;

import kg.megacom.students1.mappers.StudentMapper;
import kg.megacom.students1.mappers.TeacherMapper;
import kg.megacom.students1.models.Teacher;
import kg.megacom.students1.models.dto.TeacherDto;
import kg.megacom.students1.repositories.TeacherRepo;
import kg.megacom.students1.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
@Autowired
TeacherRepo teacherRepo;
private final TeacherMapper teacherMapper;

    public TeacherServiceImpl(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }


    @Override
    public TeacherDto createTeacher(Teacher teacher) {
        teacherRepo.save(teacher);
        return teacherMapper.toDto(teacher);

    }

    @Override
    public List<TeacherDto> findAll() {
  List<Teacher>teacherList=teacherRepo.findAll();
  return teacherMapper.toDtoList(teacherList);

    }

    @Override
    public Teacher updateTeacher(Long id, String title) {
      //  teacherRepo.update(id,title);
      //  return teacherRepo.findById(id).get();


        Optional<Teacher>teacher=teacherRepo.findById(id);
        teacher.get().setTitle(title);
        return teacherRepo.save(teacher.get());


    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepo.delete(teacherRepo.findById(id).get());

    }
}
