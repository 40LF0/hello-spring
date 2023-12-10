package study.service;

import org.springframework.data.domain.Page;
import study.domain.Mission;
import study.domain.Review;
import study.domain.Store;

import java.util.Optional;

public interface StoreQueryService {
    Store findStore(Long id);

    Page<Review> getReviewList(Long storeId, Integer page);

    Page<Mission> getMissionList(Long storeId, Integer page);
}
