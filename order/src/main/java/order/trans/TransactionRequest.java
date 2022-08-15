package order.trans;

import lombok.Data;
import order.Order;

@Data
public class TransactionRequest {
    private Order order;
    private Payment payment;
}
