package com.x_ticket.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "eventShifts")
public class EventShift {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String eventId;
    private String time;

    // Getters and Setters
}
