package com.rafael.game_platform.games.records;

import com.rafael.game_platform.games.Game;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {
    public GameDto toDto(Game game) {
        return new GameDto(
                game.getTitle(),
                game.getGenre(),
                game.getPrice(),
                game.getReleaseDate(),
                game.getDeveloper().getUsername()
        );
    }
}
