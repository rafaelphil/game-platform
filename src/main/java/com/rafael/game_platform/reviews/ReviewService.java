package com.rafael.game_platform.reviews;

import com.rafael.game_platform.exceptions.ReviewAlreadyExistsException;
import com.rafael.game_platform.games.Game;
import com.rafael.game_platform.games.GameRepository;
import com.rafael.game_platform.reviews.records.CreateReviewRequest;
import com.rafael.game_platform.reviews.records.ReviewDto;
import com.rafael.game_platform.reviews.records.ReviewMapper;
import com.rafael.game_platform.users.User;
import com.rafael.game_platform.users.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {
    private final  ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private final ReviewMapper reviewMapper;

    public List<ReviewDto> getReviews() {
        return reviewRepository.findAll().stream().map(reviewMapper::toDto).toList();
    }

    public ReviewDto createReview(CreateReviewRequest createReviewRequest) {
        User user = userRepository.getById(createReviewRequest.userId());
        Game game = gameRepository.getById(createReviewRequest.gameId());

        if(reviewRepository.existsByGameAndAuthor(game, user)){
            throw new ReviewAlreadyExistsException();
        }

        Review review = new Review();
        review.setContent(createReviewRequest.content());
        review.setRating(createReviewRequest.rating());
        review.setGame(game);
        review.setAuthor(user);
        review.setCreatedAt(LocalDateTime.now());

        reviewRepository.save(review);
        return reviewMapper.toDto(reviewRepository.save(review));
    }
}
