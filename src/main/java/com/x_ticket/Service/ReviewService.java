package com.x_ticket.Service;

import com.x_ticket.Model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> getAllReviews();
    Optional<Review> getReviewById(String id);
    Review createReview(Review review);
    Review updateReview(String id, Review reviewDetails);
    void deleteReview(String id);
}
