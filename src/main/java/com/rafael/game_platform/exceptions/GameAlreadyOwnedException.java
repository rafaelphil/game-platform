package com.rafael.game_platform.exceptions;

import com.rafael.game_platform.games.Game;
import com.rafael.game_platform.users.User;

public class GameAlreadyOwnedException extends RuntimeException{
    public GameAlreadyOwnedException(User user, Game game){
        super(user.getUsername() + " already owns " + game.getTitle());
    }
}
