package com.rafael.game_platform.exceptions;

import com.rafael.game_platform.games.Game;
import com.rafael.game_platform.users.User;

public class GameNotOwnedException extends RuntimeException{
    public GameNotOwnedException(User user, Game game){
        super(user.getUsername() + " does not own " + game.getTitle());
    }
    public GameNotOwnedException(){
        super("Game not owned");
    }
}
