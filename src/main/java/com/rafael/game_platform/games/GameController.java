package com.rafael.game_platform.games;

import com.rafael.game_platform.games.records.CreateGameRequest;
import com.rafael.game_platform.games.records.GameDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;

    @GetMapping
    public List<GameDto> getGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDto> getGame(@PathVariable Long id) {
        GameDto gameDto = gameService.getGame(id);
        if (gameDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gameDto);
    }

    @PostMapping
    public ResponseEntity<GameDto> createGame(@RequestBody CreateGameRequest createGameRequest) {
        GameDto dto = gameService.createGame(createGameRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}
