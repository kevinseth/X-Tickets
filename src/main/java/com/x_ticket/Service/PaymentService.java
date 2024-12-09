package com.x_ticket.Service;

import com.x_ticket.Model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    List<Payment> getAllPayments();
    Optional<Payment> getPaymentById(String id);
    Payment createPayment(Payment payment);
    Payment updatePayment(String id, Payment paymentDetails);
    void deletePayment(String id);
}
