package study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.common.apiResponse.code.status.ErrorStatus;
import study.common.apiResponse.exception.handler.ErrorHandler;
import study.converter.StoreConverter;
import study.domain.*;
import study.repository.RegionRepository;
import study.repository.StoreRepository;
import study.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;

    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store joinStore(StoreRequestDTO.StoreJoinDto request) {
        Store store = StoreConverter.toStore(request);
        Region region = regionRepository.findById(request.getRegionId()).orElseThrow(() -> new ErrorHandler(ErrorStatus.REGION_NOT_FOUND));
        store.setRegion(region);
        return storeRepository.save(store);
    }

}