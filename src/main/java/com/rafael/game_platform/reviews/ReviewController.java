package com.rafael.game_platform.reviews;

import com.rafael.game_platform.reviews.records.CreateReviewRequest;
import com.rafael.game_platform.reviews.records.ReviewDto;
import com.rafael.game_platform.reviews.records.UpdateReviewRequest;
import jakarta.validation.Valid;
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
    public ResponseEntity<ReviewDto> createReview(@RequestBody CreateReviewRequest createReviewRequest) {
        ReviewDto dto = reviewService.createReview(createReviewRequest);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewDto> updateReview(@PathVariable Long id, @Valid @RequestBody UpdateReviewRequest updateReviewRequest) {
        ReviewDto dto = reviewService.updateReview(id, updateReviewRequest);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok().build();
    }
}
