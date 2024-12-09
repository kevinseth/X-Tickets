package com.x_ticket.Repository;

import com.x_ticket.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
