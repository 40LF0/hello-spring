package study.converter;

import study.domain.Category;
import study.domain.MemberPrefer;
import study.domain.Review;
import study.domain.ReviewImage;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewImageConverter {

    public static List<ReviewImage> toReviewImageList(Review review, List<String> urlList) {
        return urlList.stream()
                .map(
                        url -> ReviewImage.builder()
                                .review(review)
                                .imageUrl(url)
                                .build()
                ).collect(Collectors.toList());

    }
}
