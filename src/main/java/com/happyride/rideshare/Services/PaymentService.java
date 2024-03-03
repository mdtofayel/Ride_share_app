package com.happyride.rideshare.Services;


import com.happyride.rideshare.Repository.PaymentRepository;
import com.happyride.rideshare.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment findPaymentById(int id) {

        return paymentRepository.findPaymentByPaymentId(id);
    }

    public Payment savePayment(Payment payment) {

        return paymentRepository.save(payment);
    }
}
