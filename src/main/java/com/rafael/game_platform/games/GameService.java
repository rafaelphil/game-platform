package com.rafael.game_platform.games;

import com.rafael.game_platform.exceptions.GameAlreadyExistsException;
import com.rafael.game_platform.exceptions.GameNotFoundException;
import com.rafael.game_platform.games.records.CreateGameRequest;
import com.rafael.game_platform.games.records.GameDto;
import com.rafael.game_platform.games.records.GameMapper;
import com.rafael.game_platform.users.User;
import com.rafael.game_platform.users.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
        Game game = gameRepository.findById(id).orElseThrow(GameNotFoundException::new);
        return gameMapper.toDto(game);
    }

    public GameDto createGame(CreateGameRequest createGameRequest) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername());
        if(gameRepository.existsByDeveloperAndTitle(user, createGameRequest.title())){
            throw new GameAlreadyExistsException(createGameRequest.title());
        }

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

    public void deleteGame(Long id) {
        if(!gameRepository.existsById(id)) throw new GameNotFoundException();
        gameRepository.deleteById(id);
    }
}
