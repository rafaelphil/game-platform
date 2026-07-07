package com.rafael.game_platform.users;

import com.rafael.game_platform.games.Game;
import com.rafael.game_platform.library.Library;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    @NotBlank
    @Size(min = 8)
    private String password;
    private LocalDateTime lastOnline;
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "developer")
    private List<Game> games;
    @OneToMany(mappedBy = "user")
    private List<Library> libraryGames;
}
