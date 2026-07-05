package com.rafael.game_platform.games.records;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record CreateGameRequest(
        @NotBlank
        @Size(min = 1, max = 50)
        String title,
        @NotBlank
        String genre,
        @Min(0)
        Float price,
        Long developerId
) {
}
