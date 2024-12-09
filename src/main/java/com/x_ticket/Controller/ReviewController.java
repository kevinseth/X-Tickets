package com.x_ticket.Controller;

import com.x_ticket.Model.Review;
import com.x_ticket.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public Optional<Review> getReviewById(@PathVariable String id) {
        return reviewService.getReviewById(id);
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable String id, @RequestBody Review reviewDetails) {
        return reviewService.updateReview(id, reviewDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable String id) {
        reviewService.deleteReview(id);
    }
}
