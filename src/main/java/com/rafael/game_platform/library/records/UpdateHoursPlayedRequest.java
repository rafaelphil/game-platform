package com.rafael.game_platform.library.records;

import jakarta.validation.constraints.Min;

public record UpdateHoursPlayedRequest(
        Long userId,
        Long gameId,
        @Min(0)
        Integer hoursPlayed
) {
}
