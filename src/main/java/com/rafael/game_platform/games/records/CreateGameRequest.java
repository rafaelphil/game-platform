package com.rafael.game_platform.games.records;

import java.time.LocalDateTime;

public record CreateGameRequest(
        String title,
        String genre,
        Float price,
        Long developerId
) {
}
