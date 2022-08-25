package kg.megacom.students1.services.impl;

import kg.megacom.students1.models.Student;
import kg.megacom.students1.repositories.StudentRepo;
import kg.megacom.students1.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public ResponseEntity createPayment2(Long group_id, Long student_id, double summa) {
        return null;
    }
/* private final   StudentRepo studentRepo;
    @Override
    public ResponseEntity createPayment2(Long group_id, Long student_id, double summa) {
Student student=studentRepo.findById(student_id).get();
    }*/
}
