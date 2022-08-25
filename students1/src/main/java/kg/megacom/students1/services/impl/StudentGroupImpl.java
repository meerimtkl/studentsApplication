package kg.megacom.students1.services.impl;

import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.StudentGroups;
import kg.megacom.students1.models.enums.StudentStatus;
import kg.megacom.students1.repositories.GroupRepo;
import kg.megacom.students1.repositories.StudentGroupsRepo;
import kg.megacom.students1.repositories.StudentRepo;
import kg.megacom.students1.services.StudentGroupService;
import kg.megacom.students1.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class StudentGroupImpl implements StudentGroupService {

       private final StudentRepo studentRepo;
       private final GroupRepo groupRepo;
       private final StudentGroupsRepo studentGroupsRepo;


    public StudentGroupImpl (StudentRepo studentRepo,GroupRepo groupRepo,StudentGroupsRepo studentGroupRepo){
        this.studentRepo = studentRepo;
        this.groupRepo=groupRepo;
        this.studentGroupsRepo=studentGroupRepo;

        }

    @Override
    public ResponseEntity create(Date startDate, Date endDate, Long studentId, Long groupId) {
      try{
          Student student=studentRepo.findById(studentId).get();
        //  if(student.isDeleted()){
    //         return  ResponseEntity.ok("Student is deleted");
       //   }
StudentGroups studentGroups=new StudentGroups();
          studentGroups.setStudent(student);
          studentGroups.setGroup(groupRepo.findById(groupId).get());
          studentGroups.setStartDate(startDate);
          studentGroups.setEndDate(endDate);
          studentGroups.setStatus(StudentStatus.STUDIED);
          return ResponseEntity.ok(studentGroupsRepo.save(studentGroups));
      }catch (Exception e){
          return ResponseEntity.ok("Entity doesn't exists");
      }
    }
}
