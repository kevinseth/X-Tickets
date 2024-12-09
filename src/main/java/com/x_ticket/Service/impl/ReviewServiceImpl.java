package com.x_ticket.Service.impl;

import com.x_ticket.Model.Review;
import com.x_ticket.Repository.ReviewRepository;
import com.x_ticket.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Optional<Review> getReviewById(String id) {
        return reviewRepository.findById(id);
    }

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(String id, Review reviewDetails) {
        Review review = reviewRepository.findById(id).orElseThrow();
        // Update review details
        return reviewRepository.save(review);
    }

    @Override
    public void deleteReview(String id) {
        reviewRepository.deleteById(id);
    }
}
