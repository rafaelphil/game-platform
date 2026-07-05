package com.rafael.game_platform.games;

import com.rafael.game_platform.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
    public boolean existsByDeveloperAndTitle(User developer, String title);
}
