package com.x_ticket.Repository;

import com.x_ticket.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // Custom JPQL Query: Find events by category
    @Query("SELECT e FROM Event e WHERE e.category = :category")
    List<Event> findEventsByCategory(@Param("category") String category);

    // Custom JPQL Query: Count events by category
    @Query("SELECT COUNT(e) FROM Event e WHERE e.category = :category")
    Long countEventsByCategory(@Param("category") String category);
}
