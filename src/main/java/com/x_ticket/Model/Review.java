package com.x_ticket.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participantId")
    private User participant;

    @Column(columnDefinition = "int default 1")
    private int rating = 1;

    private String comment;

    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime updatedAt = LocalDateTime.now();

    // Getters and Setters
}