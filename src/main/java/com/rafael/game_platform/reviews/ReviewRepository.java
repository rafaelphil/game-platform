package com.rafael.game_platform.reviews;

import com.rafael.game_platform.games.Game;
import com.rafael.game_platform.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    public boolean existsByGameAndAuthor(Game game, User author);
}
