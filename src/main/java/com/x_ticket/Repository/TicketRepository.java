package com.x_ticket.Repository;

import com.x_ticket.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, String> {
}
