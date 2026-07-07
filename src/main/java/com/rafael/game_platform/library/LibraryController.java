package com.rafael.game_platform.library;

import com.rafael.game_platform.library.records.LibraryDto;
import com.rafael.game_platform.users.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/library")
public class LibraryController {
    private final LibraryService libraryService;

    @GetMapping
    public List<LibraryDto> findAll(@RequestParam(required = false) String username){
        if(username != null){
            return  libraryService.findByUsername(username);
        }

        return libraryService.findAll();
    }
}
