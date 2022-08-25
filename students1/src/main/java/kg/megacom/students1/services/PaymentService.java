package kg.megacom.students1.services;

import org.springframework.http.ResponseEntity;

public interface PaymentService {

    public ResponseEntity createPayment2(Long group_id,Long student_id,double summa);

}
