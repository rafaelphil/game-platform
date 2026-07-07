package com.rafael.game_platform.library.records;

public record CreateLibraryRequest(
        Long userId,
        Long gameId
) {
}
