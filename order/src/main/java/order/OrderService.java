package order;

import order.trans.Payment;
import order.trans.TransactionRequest;
import order.trans.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private IOrderRepo orderRepo;
    @Autowired
    RestTemplate restTemplate;

    public TransactionResponse place(TransactionRequest transactionRequest) {
        Order order = transactionRequest.getOrder();
        Payment payment = transactionRequest.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/pay", payment, Payment.class);

        String response = paymentResponse.getStatus().equals("Fully Paid") ? "Payment successful." : "Payment failed.";
        orderRepo.save(order);
        return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
    }
}
