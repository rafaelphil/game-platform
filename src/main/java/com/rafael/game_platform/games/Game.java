package com.rafael.game_platform.games;

import com.rafael.game_platform.users.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    private Float price;
    private LocalDateTime releaseDate;
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "developer_id")
    private User developer;
}
