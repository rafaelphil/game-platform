package com.rafael.game_platform.library;

import com.rafael.game_platform.games.Game;
import com.rafael.game_platform.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibraryRepository extends JpaRepository<Library, Long> {
    List<Library> findByUser(User user);
    boolean existsByUserAndGame(User user, Game game);
    Optional<Library> findByUserAndGame(User user, Game game);
}
