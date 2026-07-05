package com.rafael.game_platform.exceptions;

public class ReviewAlreadyExistsException extends RuntimeException {
    public ReviewAlreadyExistsException() {
        super("Review already exists");
    }
}
