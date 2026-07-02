package com.rafael.game_platform.games;

import com.rafael.game_platform.games.records.CreateGameRequest;
import com.rafael.game_platform.games.records.GameDto;
import com.rafael.game_platform.games.records.GameMapper;
import com.rafael.game_platform.users.User;
import com.rafael.game_platform.users.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class GameService {
    private final GameRepository gameRepository;
    private final UserRepository userRepository;
    private final GameMapper gameMapper;

    public List<GameDto> getAllGames() {
        return gameRepository.findAll().stream().map(gameMapper::toDto).toList();
    }

    public GameDto getGame(Long id) {
        Game game = gameRepository.findById(id).orElse(null);
        if(game == null){
            return null;
        }
        return gameMapper.toDto(game);
    }

    public GameDto createGame(CreateGameRequest createGameRequest) {
        Game game = new Game();
        game.setTitle(createGameRequest.title());
        game.setGenre(createGameRequest.genre());
        game.setPrice(createGameRequest.price());
        game.setCreatedAt(LocalDateTime.now());
        game.setReleaseDate(LocalDateTime.now().plusWeeks(1));
        game.setDeveloper(userRepository.findById(createGameRequest.developerId()).orElse(null));
        gameRepository.save(game);
        return gameMapper.toDto(game);
    }
}
