package com.x_ticket.Controller;

import com.x_ticket.Model.Event;
import com.x_ticket.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public Optional<Event> getEventById(@PathVariable String id) {
        return eventService.getEventById(id);
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable String id, @RequestBody Event eventDetails) {
        return eventService.updateEvent(id, eventDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable String id) {
        eventService.deleteEvent(id);
    }
}
