package com.x_ticket.Repository;

import com.x_ticket.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // Custom JPQL Query: Find tickets by eventId
    @Query("SELECT t FROM Ticket t WHERE t.eventId = :eventId")
    List<Ticket> findTicketsByEventId(@Param("eventId") String eventId);

    // Custom JPQL Query: Count tickets by eventId
    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.eventId = :eventId")
    Long countTicketsByEventId(@Param("eventId") String eventId);
}
