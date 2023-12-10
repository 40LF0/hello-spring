package study.converter;

import study.domain.Review;
import study.web.dto.*;

public class ReviewConverter {
    public static ReviewResponseDTO.ReviewJoinResultDTO toJoinResultDTO(Review review) {
        return ReviewResponseDTO.ReviewJoinResultDTO.builder()
                .reviewId(review.getReviewId())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.ReviewJoinDto request) {
        return Review.builder()
                .body(request.getBody())
                .score(request.getScore())
                .build();
    }
}