package com.x_ticket.Repository;

import com.x_ticket.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Custom JPQL Query: Find reviews by rating
    @Query("SELECT r FROM Review r WHERE r.rating = :rating")
    List<Review> findReviewsByRating(@Param("rating") int rating);

    // Custom JPQL Query: Count reviews by rating
    @Query("SELECT COUNT(r) FROM Review r WHERE r.rating = :rating")
    Long countReviewsByRating(@Param("rating") int rating);
}
