package kg.megacom.students1.services;

import kg.megacom.students1.models.StudentGroups;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public interface StudentGroupService {
    ResponseEntity create(Date startDate, Date endDate, Long studentId, Long groupId);

StudentGroups append(Long studentId,Long groupId);
}
