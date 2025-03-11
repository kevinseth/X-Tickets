package com.x_ticket.Model;

import com.x_ticket.Model.enums.TicketTypeEnum;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, length = 20) // Allocate 20 characters for the tracking code
    private String trackingCode;

    @Column(length = 20) // Allocate 20 characters for the first name
    private String firstName;

    @Column(length = 20) // Allocate 20 characters for the last name
    private String lastName;

    @Column(length = 15) // Allocate 15 characters for the phone number
    private String phone;

    @Column(length = 100) // Allocate 100 characters for the email
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255) default 'GENERAL'")
    private TicketTypeEnum ticketType = TicketTypeEnum.GENERAL;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventId", referencedColumnName = "id")
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @Column(columnDefinition = "boolean default false")
    private boolean isChecked = false;

    private LocalDateTime checkedAt;

    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime updatedAt = LocalDateTime.now();

    // Getters and Setters
}