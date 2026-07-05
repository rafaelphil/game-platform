package com.rafael.game_platform.exceptions;

public class GameAlreadyExistsException extends RuntimeException{
    public GameAlreadyExistsException(String title) {
        super("Game " + title + " already exists");
    }
}
