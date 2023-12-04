package study.domain.member;

public interface MemberCommandService {
    public Member joinMember(MemberRequestDTO.JoinDto request);
}
