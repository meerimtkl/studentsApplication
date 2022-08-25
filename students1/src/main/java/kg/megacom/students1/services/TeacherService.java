package kg.megacom.students1.services;

import kg.megacom.students1.models.Teacher;
import kg.megacom.students1.models.dto.TeacherDto;
import java.util.List;

public interface TeacherService {
     TeacherDto createTeacher(Teacher teacher);
     List<TeacherDto>findAll();
     Teacher updateTeacher(Long id, String title);
     void deleteTeacher(Long id);

}
