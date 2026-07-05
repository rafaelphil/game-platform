package com.rafael.game_platform.reviews.records;

public record CreateReviewRequest(
        String content,
        Float rating,
        Long gameId,
        Long userId
) {
}
