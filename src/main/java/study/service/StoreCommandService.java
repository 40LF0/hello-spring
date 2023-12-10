package study.service;

import study.domain.Store;
import study.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    public Store joinStore(StoreRequestDTO.StoreJoinDTO request);
}
