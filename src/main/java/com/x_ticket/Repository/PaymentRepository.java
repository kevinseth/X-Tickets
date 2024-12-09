package com.x_ticket.Repository;

import com.x_ticket.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, String> {
}
