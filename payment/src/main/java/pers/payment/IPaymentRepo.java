package pers.payment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepo extends JpaRepository<Payment, Integer> {
}
