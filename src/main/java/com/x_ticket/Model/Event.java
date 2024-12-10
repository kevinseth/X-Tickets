package com.x_ticket.Model;

import java.time.LocalDateTime;

import com.x_ticket.Model.enums.EventCategoryEnum;
import com.x_ticket.Model.enums.EventTypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String image;
    private String description;
    private int maxTickets;

    @Column(columnDefinition = "int default 0")
    private int availableTickets = 0;

    private LocalDateTime date;
    private String location;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime startSellingDate;
    private LocalDateTime endSellingDate;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255) default 'PAID'")
    private EventTypeEnum eventType = EventTypeEnum.PAID;

    @Enumerated(EnumType.STRING)
    private EventCategoryEnum eventCategory;

    private String companyId;

    @Column(columnDefinition = "boolean default true")
    private boolean active = true;

    @Column(columnDefinition = "boolean default false")
    private boolean isPrivate = false;

    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime updatedAt = LocalDateTime.now();

    // Getters and Setters
}
