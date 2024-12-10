package com.x_ticket.Repository;

import com.x_ticket.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Custom JPQL Query: Find payments by ticketId
    @Query("SELECT p FROM Payment p WHERE p.ticketId = :ticketId")
    List<Payment> findPaymentsByTicketId(@Param("ticketId") String ticketId);

    // Custom JPQL Query: Count payments by ticketId
    @Query("SELECT COUNT(p) FROM Payment p WHERE p.ticketId = :ticketId")
    Long countPaymentsByTicketId(@Param("ticketId") String ticketId);
}
