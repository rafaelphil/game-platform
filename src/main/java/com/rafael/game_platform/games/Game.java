package com.rafael.game_platform.games;

import com.rafael.game_platform.users.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="games",  uniqueConstraints = @UniqueConstraint(columnNames = {"developer_id","title"}))
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 1, max = 50)
    private String title;
    @NotBlank
    private String genre;
    @Min(0)
    private Float price;
    private LocalDateTime releaseDate;
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "developer_id")
    private User developer;
}
