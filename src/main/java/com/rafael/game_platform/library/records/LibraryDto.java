package com.rafael.game_platform.library.records;

import java.time.LocalDateTime;

public record LibraryDto(
    Integer hoursPlayed,
    LocalDateTime lastPlayedAt,
    LocalDateTime addedAt,
    String username,
    String gameTitle
) {
}
