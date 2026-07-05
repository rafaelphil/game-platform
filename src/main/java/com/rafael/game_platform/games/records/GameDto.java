package com.rafael.game_platform.games.records;

import com.rafael.game_platform.users.User;

import java.time.LocalDateTime;

public record GameDto(
        String title,
        String genre,
        Float price,
        LocalDateTime releaseDate,
        String developerName
) {
}
