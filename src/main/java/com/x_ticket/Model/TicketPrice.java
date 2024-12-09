package com.x_ticket.Model;

import com.x_ticket.Model.enums.TicketTypeEnum;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticketPrices")
public class TicketPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String eventId;

    @Enumerated(EnumType.STRING)
    private TicketTypeEnum type;

    private int price;

    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime updatedAt = LocalDateTime.now();

    // Getters and Setters
}
