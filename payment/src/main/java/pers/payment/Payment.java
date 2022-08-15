package pers.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payment_details")
public class Payment {
    @Id
    @SequenceGenerator(name = "payment_sequence", allocationSize = 1)
    @GeneratedValue(generator = "payment_sequence", strategy = GenerationType.SEQUENCE)
    private int id;
    private String status;
    private String transactionId;
    private int orderId;
    private double amount;
}
