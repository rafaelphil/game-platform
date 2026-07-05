package com.rafael.game_platform.reviews.records;

import com.rafael.game_platform.reviews.Review;

public class ReviewMapper {
    ReviewDto toDto(Review review) {
        return new  ReviewDto(
                review.getContent(),
                review.getRating(),
                review.getGame().getTitle(),
                review.getAuthor().getUsername(),
                review.getCreatedAt()
        );
    }
}
