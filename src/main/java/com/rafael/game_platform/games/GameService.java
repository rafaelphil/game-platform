package com.rafael.game_platform.games;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameService {
    private final GameRepository gameRepository;
}
