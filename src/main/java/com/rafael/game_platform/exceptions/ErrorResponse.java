package com.rafael.game_platform.exceptions;

public record ErrorResponse(
        int status,
        String error,
        String message
) {
}
