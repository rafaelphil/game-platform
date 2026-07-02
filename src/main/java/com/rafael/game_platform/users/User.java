package com.rafael.game_platform.users;

import com.rafael.game_platform.games.Game;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private LocalDateTime lastOnline;
    private LocalDateTime createdAt;
    @OneToMany(mappedBy = "developer")
    private List<Game> games;
}
