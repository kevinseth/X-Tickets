package com.x_ticket.Controller;

import com.x_ticket.Model.Payment;
import com.x_ticket.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public Optional<Payment> getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/ticketId/{ticketId}")
    public List<Payment> getPaymentsByTicketId(@PathVariable String ticketId) {
        return paymentService.getPaymentsByTicketId(ticketId);
    }

    @GetMapping("/count-ticketId/{ticketId}")
    public Long countPaymentsByTicketId(@PathVariable String ticketId) {
        return paymentService.countPaymentsByTicketId(ticketId);
    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }

    @PutMapping("/{id}")
    public Payment updatePayment(@PathVariable Long id, @RequestBody Payment paymentDetails) {
        return paymentService.updatePayment(id, paymentDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
    }
}
