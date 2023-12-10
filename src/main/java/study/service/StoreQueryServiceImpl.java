package study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.common.apiResponse.code.status.ErrorStatus;
import study.common.apiResponse.exception.handler.ErrorHandler;
import study.domain.Review;
import study.domain.Store;
import study.repository.ReviewRepository;
import study.repository.StoreRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService{

    private final StoreRepository storeRepository;

    private final ReviewRepository reviewRepository;
    @Override
    public Store findStore(Long id) {
        Optional<Store> store = storeRepository.findById(id);
        if(store.isPresent()){
            return store.get();
        }
        throw new ErrorHandler(ErrorStatus.STORE_NOT_FOUND);
    }

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {
        Store store = findStore(storeId);
        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }
}
