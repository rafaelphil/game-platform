package com.rafael.game_platform.reviews.records;

import java.time.LocalDateTime;

public record ReviewDto(
        String content,
        Float rating,
        String gameTitle,
        String username,
        LocalDateTime createdAt
) {
}
