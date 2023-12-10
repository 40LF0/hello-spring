package study.service;

import org.springframework.data.domain.Page;
import study.domain.Review;
import study.domain.Store;

import java.util.Optional;

public interface StoreQueryService {
    Store findStore(Long id);

    Page<Review> getReviewList(Long StoreId, Integer page);
}
