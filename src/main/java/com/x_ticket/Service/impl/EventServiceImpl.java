package com.x_ticket.Service.impl;

import com.x_ticket.Model.Event;
import com.x_ticket.Repository.EventRepository;
import com.x_ticket.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<Event> getEventById(String id) {
        return eventRepository.findById(id);
    }

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(String id, Event eventDetails) {
        Event event = eventRepository.findById(id).orElseThrow();
        // Update event details
        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(String id) {
        eventRepository.deleteById(id);
    }
}
