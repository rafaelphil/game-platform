package com.rafael.game_platform.library;

import com.rafael.game_platform.games.Game;
import com.rafael.game_platform.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibraryRepository extends JpaRepository<Library, Long> {
    public List<Library> findByUser(User user);
    public boolean existsByUserAndGame(User user, Game game);
    public Optional<Library> findByUserAndGame(User user, Game game);
}
