package pers.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private IPaymentRepo paymentRepo;

    public Payment pay(Payment payment) {
        payment.setStatus(processPayment());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepo.save(payment);
    }

    public String processPayment() {
        return "Success";
    }
}
