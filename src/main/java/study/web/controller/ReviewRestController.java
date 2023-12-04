package study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.common.apiResponse.ApiResponse;
import study.converter.ReviewConverter;
import study.domain.Review;
import study.service.ReviewCommandService;
import study.web.dto.ReviewRequestDTO;
import study.web.dto.ReviewResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.ReviewJoinResultDTO> join(@RequestBody @Valid ReviewRequestDTO.ReviewJoinDto request){
        Review review = reviewCommandService.joinReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toJoinResultDTO(review));
    }
}
