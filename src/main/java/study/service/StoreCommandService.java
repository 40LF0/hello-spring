package study.service;

import study.domain.Member;
import study.domain.Store;
import study.web.dto.MemberRequestDTO;
import study.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    public Store joinStore(StoreRequestDTO.JoinDto request);
}
