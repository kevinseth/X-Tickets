package com.x_ticket.Service.impl;

import com.x_ticket.Model.Ticket;
import com.x_ticket.Repository.TicketRepository;
import com.x_ticket.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Optional<Ticket> getTicketById(String id) {
        return ticketRepository.findById(id);
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket updateTicket(String id, Ticket ticketDetails) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow();
        // Update ticket details
        return ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicket(String id) {
        ticketRepository.deleteById(id);
    }
}
