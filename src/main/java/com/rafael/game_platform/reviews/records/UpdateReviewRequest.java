package com.rafael.game_platform.reviews.records;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record UpdateReviewRequest(
        @NotBlank
        String newContent,
        @Min(0)
        @Max(10)
        Float newRating
) {
}
