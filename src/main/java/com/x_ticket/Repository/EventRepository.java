package com.x_ticket.Repository;

import com.x_ticket.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, String> {
}
