package com.rafael.game_platform.reviews;

import com.rafael.game_platform.reviews.records.CreateReviewRequest;
import com.rafael.game_platform.reviews.records.ReviewDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewDto> getAllReviews() {
        return reviewService.getReviews();
    }

    @PostMapping
    public ReviewDto createReview(@RequestBody CreateReviewRequest createReviewRequest) {
        return reviewService.createReview(createReviewRequest);
    }
}
