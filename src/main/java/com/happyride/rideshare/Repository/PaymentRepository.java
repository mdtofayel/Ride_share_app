package com.happyride.rideshare.Repository;


import com.happyride.rideshare.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findPaymentByPaymentId(int id);
}
