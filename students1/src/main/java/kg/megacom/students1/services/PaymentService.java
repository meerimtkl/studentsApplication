package kg.megacom.students1.services;

import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.Payment;
import kg.megacom.students1.models.Student;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface PaymentService {

    public ResponseEntity createPayment2(Long group_id,Long student_id,double summa);
List<Payment> setPayments(Student student, Group group);

}
