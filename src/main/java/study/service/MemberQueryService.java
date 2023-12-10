package study.service;

import org.springframework.data.domain.Page;
import study.domain.Member;
import study.domain.Mission;
import study.domain.Review;
import study.domain.Store;

public interface MemberQueryService {
    Member findMember(Long id);

    Page<Review> getReviewList(Long userId, Integer page);

    Page<Mission> getProgressMissionList(Long userId, Integer page);
}
