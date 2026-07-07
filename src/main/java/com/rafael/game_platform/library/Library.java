package com.rafael.game_platform.library;

import com.rafael.game_platform.games.Game;
import com.rafael.game_platform.users.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="libraries", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id","game_id"}))
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(0)
    private Integer hoursPlayed;
    private LocalDateTime lastPlayedAt;
    private LocalDateTime addedAt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
}
