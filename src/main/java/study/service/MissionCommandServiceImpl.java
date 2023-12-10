package study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.common.apiResponse.code.status.ErrorStatus;
import study.common.apiResponse.exception.handler.ErrorHandler;
import study.converter.MissionConverter;
import study.converter.ReviewConverter;
import study.converter.ReviewImageConverter;
import study.domain.*;
import study.repository.MemberRepository;
import study.repository.MissionRepository;
import study.repository.ReviewRepository;
import study.repository.StoreRepository;
import study.web.dto.MissionRequestDTO;
import study.web.dto.ReviewRequestDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Transactional
    @Override
    public Mission joinMission(MissionRequestDTO.MissionJoinDto request) {
        Mission mission = MissionConverter.toMission(request);
        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(
                () -> new ErrorHandler(ErrorStatus.STORE_NOT_FOUND)
        );
        mission.setStore(store);
        return missionRepository.save(mission);
    }
}
