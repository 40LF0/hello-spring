package study.converter;

import org.springframework.data.domain.Page;
import study.domain.Review;
import study.domain.Store;
import study.web.dto.ReviewResponseDTO;
import study.web.dto.StoreRequestDTO;
import study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {
    public static StoreResponseDTO.StoreJoinResultDTO toJoinResultDTO(Store store) {
        return StoreResponseDTO.StoreJoinResultDTO.builder()
                .storeId(store.getStoreId())
                .createdAt(store.getCreatedAt())
                .build();
    }

    public static Store toStore(StoreRequestDTO.StoreJoinDTO request) {
        return Store.builder()
                .address(request.getAddress())
                .score(request.getScore())
                .name(request.getName())
                .build();
    }

    public static Review toReview(StoreRequestDTO.ReviewDTO request){
        return Review.builder()
                .score(request.getScore())
                .body(request.getBody())
                .build();
    }

    public static StoreResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review){
        return StoreResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getReviewId())
                .createdAt(LocalDateTime.now())
                .build();
    }




}