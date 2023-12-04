package study.service;

import study.domain.Review;
import study.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    public Review joinReview(ReviewRequestDTO.ReviewJoinDto request);
}
