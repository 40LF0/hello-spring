package study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.common.apiResponse.code.status.ErrorStatus;
import study.common.apiResponse.exception.handler.ErrorHandler;
import study.converter.ReviewConverter;
import study.converter.ReviewImageConverter;
import study.domain.Member;
import study.domain.Review;
import study.domain.ReviewImage;
import study.domain.Store;
import study.repository.MemberRepository;
import study.repository.ReviewRepository;
import study.repository.StoreRepository;
import study.web.dto.ReviewRequestDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public Review joinReview(ReviewRequestDTO.ReviewJoinDto request) {

        Review review = ReviewConverter.toReview(request);
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(()-> new ErrorHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(() -> new ErrorHandler(ErrorStatus.STORE_NOT_FOUND));
        List<ReviewImage> reviewImageList = ReviewImageConverter.toReviewImageList(review,request.getImageUrlList());
        review.setMember(member);
        review.setStore(store);
        review.setReviewImageList(reviewImageList);

        return reviewRepository.save(review);
    }
}