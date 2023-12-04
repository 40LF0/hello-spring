package study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.common.apiResponse.code.status.ErrorStatus;
import study.common.apiResponse.exception.handler.CategoryHandler;
import study.common.apiResponse.exception.handler.RegionHandler;
import study.converter.MemberConverter;
import study.converter.MemberPreferConverter;
import study.converter.StoreConverter;
import study.domain.*;
import study.repository.CategoryRepository;
import study.repository.MemberRepository;
import study.repository.RegionRepository;
import study.repository.StoreRepository;
import study.web.dto.MemberRequestDTO;
import study.web.dto.StoreRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;

    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store joinStore(StoreRequestDTO.JoinDto request) {
        Store store = StoreConverter.toStore(request);
        Region region = regionRepository.findById(request.getRegionId()).orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
        store.setRegion(region);
        return storeRepository.save(store);
    }

}