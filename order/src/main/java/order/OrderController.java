package order;

import order.trans.TransactionRequest;
import order.trans.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/order/place")
    public TransactionResponse placeOrder(@RequestBody TransactionRequest transactionRequest) {
        return orderService.place(transactionRequest);
    }
}
