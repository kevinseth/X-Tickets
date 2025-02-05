package com.x_ticket.Model;

import com.x_ticket.Model.enums.EventCategoryEnum;
import com.x_ticket.Model.enums.EventTypeEnum;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(length = 50) // Allocate 50 characters for the name
    private String name;

    @Column(length = 50) // Allocate 50 characters for the image URL
    private String image;

    @Column(length = 100) // Allocate 100 characters for the description
    private String description;

    private int maxTickets;

    @Column(columnDefinition = "int default 0")
    private int availableTickets = 0;

    private LocalDateTime date;

    @Column(length = 10) // Allocate 100 characters for the location
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId")
    private Company company;

    @Column(columnDefinition = "boolean default true")
    private boolean active = true;

    @Column(columnDefinition = "boolean default false")
    private boolean isPrivate = false;

    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TicketPrice> ticketPrices;

    // Getters and Setters
}