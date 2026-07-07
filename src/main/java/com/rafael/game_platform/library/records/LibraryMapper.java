package com.rafael.game_platform.library.records;

import com.rafael.game_platform.library.Library;
import org.springframework.stereotype.Component;

@Component
public class LibraryMapper {
    public LibraryDto toDto(Library library){
        return new LibraryDto(
                library.getHoursPlayed(),
                library.getLastPlayedAt(),
                library.getAddedAt(),
                library.getUser().getUsername(),
                library.getGame().getTitle()
        );
    }
}
