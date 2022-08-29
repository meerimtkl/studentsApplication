package kg.megacom.students1.repositories;

import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.StudentGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentGroupsRepo extends JpaRepository<StudentGroups,Long> {
    StudentGroups findByStudentAndGroup (Student student, Group group);

}
