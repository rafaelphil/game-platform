package com.rafael.game_platform.reviews;

import com.rafael.game_platform.games.Game;
import com.rafael.game_platform.users.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="reviews", uniqueConstraints = @UniqueConstraint(columnNames = {"author_id","game_id"}))
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 1, max = 1000)
    private String content;
    @Max(10)
    private Float rating;
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name="game_id")
    private Game game;
    @ManyToOne
    @JoinColumn(name="author_id")
    private User author;
}
