package com.rafael.game_platform.authentication.records;

public record LoginRequest(
        String username,
        String password
) {
}
