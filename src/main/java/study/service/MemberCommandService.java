package study.service;

import study.domain.Member;
import study.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    public Member joinMember(MemberRequestDTO.MemberJoinDto request);
}
