package com.x_ticket.Service;

import com.x_ticket.Model.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> getAllEvents();
    Optional<Event> getEventById(String id);
    Event createEvent(Event event);
    Event updateEvent(String id, Event eventDetails);
    void deleteEvent(String id);
}
