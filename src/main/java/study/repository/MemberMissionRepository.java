package study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import study.domain.Member;
import study.domain.MemberMission;
import study.domain.Mission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    default Page<MemberMission> findProgressMissionsByMember(Member member, Pageable pageable) {
        return findAllByMemberAndStatus(member, "PROGRESS", pageable);
    }
    Page<MemberMission> findAllByMemberAndStatus(Member member,String status, Pageable pageable);
}