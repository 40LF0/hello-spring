package study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.common.apiResponse.code.status.ErrorStatus;
import study.common.apiResponse.exception.handler.ErrorHandler;
import study.converter.MissionConverter;
import study.domain.Member;
import study.domain.MemberMission;
import study.domain.Mission;
import study.domain.Review;
import study.repository.MemberMissionRepository;
import study.repository.MemberRepository;
import study.repository.MissionRepository;
import study.repository.ReviewRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Member findMember(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        if(member.isPresent()){
            return member.get();
        }
        throw new ErrorHandler(ErrorStatus.MEMBER_NOT_FOUND);
    }

    @Override
    public Page<Review> getReviewList(Long userId, Integer page) {
        Member member = findMember(userId);
        return reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
    }

    @Override
    public Page<Mission> getProgressMissionList(Long userId, Integer page) {
        Member member = findMember(userId);
        Page<MemberMission> memberMissions = memberMissionRepository.findProgressMissionsByMember(member, PageRequest.of(page, 10));
        return MissionConverter.toMissionPageFromMemberMissionPage(memberMissions);
    }
}
