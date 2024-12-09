package com.x_ticket.Service;

import com.x_ticket.Model.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    List<Ticket> getAllTickets();
    Optional<Ticket> getTicketById(String id);
    Ticket createTicket(Ticket ticket);
    Ticket updateTicket(String id, Ticket ticketDetails);
    void deleteTicket(String id);
}
