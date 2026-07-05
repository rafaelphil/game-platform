package com.rafael.game_platform.reviews.records;

import com.rafael.game_platform.reviews.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public ReviewDto toDto(Review review) {
        return new  ReviewDto(
                review.getContent(),
                review.getRating(),
                review.getGame().getTitle(),
                review.getAuthor().getUsername(),
                review.getCreatedAt()
        );
    }
}
