package kg.megacom.students1.services.impl;

import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.Lesson;
import kg.megacom.students1.models.Payment;
import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.enums.PaymentStatus;
import kg.megacom.students1.repositories.PaymentRepo;
import kg.megacom.students1.services.LessonService;
import kg.megacom.students1.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepo paymentRepo;
    private final LessonService lessonService;

    public PaymentServiceImpl(PaymentRepo paymentRepo, LessonService lessonService) {
        this.paymentRepo = paymentRepo;
        this.lessonService = lessonService;
    }

    @Override
    public ResponseEntity createPayment2(Long group_id, Long student_id, double summa) {
        return null;
    }

    @Override
    public List<Payment> setPayments(Student student, Group group) {


        List<Lesson> lessons = lessonService.findLessonsByGroup(group);
        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < lessons.size(); i++) {
            if (i % group.getCourse().getPeriod() == 0) {
                Payment payment = new Payment();
                payment.setStudent(student);
                payment.setGroup(group);
                payment.setDate_payments(lessons.get(i).getDay());
                payment.setStatus(PaymentStatus.UNPAID);
                payments.add(payment);

            }
        }
        payments = paymentRepo.saveAll(payments);
        return payments;
    }
    //12
    //4
    //0 1 2 3 4 5 6 7 8 9 10 11
    //0 4 8
    //3
    //0 1 2 3 4 5 6 7 8 9 10 11
    //0 3 6 9

/* private final   StudentRepo studentRepo;
    @Override
    public ResponseEntity createPayment2(Long group_id, Long student_id, double summa) {
Student student=studentRepo.findById(student_id).get();
    }*/
}
