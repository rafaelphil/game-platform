package com.rafael.game_platform.library;

import com.rafael.game_platform.exceptions.UserNotFoundException;
import com.rafael.game_platform.library.records.LibraryDto;
import com.rafael.game_platform.library.records.LibraryMapper;
import com.rafael.game_platform.users.User;
import com.rafael.game_platform.users.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final LibraryMapper libraryMapper;
    private final UserRepository userRepository;

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
}
