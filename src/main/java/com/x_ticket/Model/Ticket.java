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

    @Column(unique = true)
    private String trackingCode;

    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255) default 'GENERAL'")
    private TicketTypeEnum ticketType = TicketTypeEnum.GENERAL;

    private String eventId;

    @Column(columnDefinition = "boolean default false")
    private boolean isChecked = false;

    private LocalDateTime checkedAt;

    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime updatedAt = LocalDateTime.now();

    // Getters and Setters
}
