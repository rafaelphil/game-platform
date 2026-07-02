package com.rafael.game_platform.games;

import com.rafael.game_platform.games.records.GameDto;
import com.rafael.game_platform.games.records.GameMapper;
import com.rafael.game_platform.users.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameService {
    private final GameRepository gameRepository;
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
}
