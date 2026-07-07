package com.rafael.game_platform.library;

import com.rafael.game_platform.exceptions.*;
import com.rafael.game_platform.games.Game;
import com.rafael.game_platform.games.GameRepository;
import com.rafael.game_platform.library.records.CreateLibraryRequest;
import com.rafael.game_platform.library.records.LibraryDto;
import com.rafael.game_platform.library.records.LibraryMapper;
import com.rafael.game_platform.library.records.UpdateHoursPlayedRequest;
import com.rafael.game_platform.users.User;
import com.rafael.game_platform.users.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.Cache;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final LibraryMapper libraryMapper;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    public List<LibraryDto> findAll(){
        return libraryRepository.findAll().stream().map(libraryMapper::toDto).toList();
    }

    public List<LibraryDto> findByUserId(Long userId){
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return libraryRepository.findByUser(user).stream().map(libraryMapper::toDto).toList();
    }

    public List<LibraryDto> findByUsername(String username){
        User user = userRepository.findByUsername(username);
        if(user == null){throw new UserNotFoundException();}
        return libraryRepository.findByUser(user).stream().map(libraryMapper::toDto).toList();
    }

    public LibraryDto addToLibrary(CreateLibraryRequest createLibraryRequest){
        User user = userRepository.findById(createLibraryRequest.userId()).orElseThrow(UserNotFoundException::new);
        Game game = gameRepository.findById(createLibraryRequest.gameId()).orElseThrow(GameNotFoundException::new);

        if(libraryRepository.existsByUserAndGame(user, game)){
            throw new GameAlreadyOwnedException(user,game);
        }

        Library library = new Library();
        library.setUser(user);
        library.setGame(game);
        library.setHoursPlayed(0);
        library.setAddedAt(LocalDateTime.now());
        libraryRepository.save(library);
        return libraryMapper.toDto(library);
    }

    public LibraryDto updateHoursPlayed(@RequestBody UpdateHoursPlayedRequest updateHoursPlayedRequest){
        User user = userRepository.findById(updateHoursPlayedRequest.userId()).orElseThrow(UserNotFoundException::new);
        Game game = gameRepository.findById(updateHoursPlayedRequest.gameId()).orElseThrow(GameNotFoundException::new);

        Library library = libraryRepository.findByUserAndGame(user, game).orElseThrow(GameNotOwnedException::new);
        library.setHoursPlayed(updateHoursPlayedRequest.hoursPlayed());

        libraryRepository.save(library);
        return libraryMapper.toDto(library);
    }
}
