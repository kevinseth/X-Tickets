package com.x_ticket.Service.impl;

import com.x_ticket.Model.Payment;
import com.x_ticket.Repository.PaymentRepository;
import com.x_ticket.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> getPaymentById(String id) {
        return paymentRepository.findById(id);
    }

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment updatePayment(String id, Payment paymentDetails) {
        Payment payment = paymentRepository.findById(id).orElseThrow();
        // Update payment details
        return paymentRepository.save(payment);
    }

    @Override
    public void deletePayment(String id) {
        paymentRepository.deleteById(id);
    }
}
