package com.x_ticket.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String account;
    private float amount;
    private String method;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticketId")
    private Ticket ticket;

    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime updatedAt = LocalDateTime.now();

    // Getters and Setters
}