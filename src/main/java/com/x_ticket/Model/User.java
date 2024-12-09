package com.x_ticket.Model;

import com.x_ticket.Model.enums.UserRoleEnum;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255) default 'USER'")
    private UserRoleEnum role = UserRoleEnum.USER;

    private String firstName;
    private String lastName;
    private String nid;
    private String phone;
    private String companyId;

    @Column(columnDefinition = "boolean default true")
    private boolean isActive = true;

    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime updatedAt = LocalDateTime.now();

    // Getters and Setters
}
