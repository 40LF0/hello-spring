package study.converter;

import study.domain.Store;
import study.web.dto.StoreRequestDTO;
import study.web.dto.StoreResponseDTO;

public class StoreConverter {
    public static StoreResponseDTO.StoreJoinResultDTO toJoinResultDTO(Store store) {
        return StoreResponseDTO.StoreJoinResultDTO.builder()
                .storeId(store.getStoreId())
                .createdAt(store.getCreatedAt())
                .build();
    }

    public static Store toStore(StoreRequestDTO.StoreJoinDto request) {
        return Store.builder()
                .address(request.getAddress())
                .score(request.getScore())
                .name(request.getName())
                .build();
    }



}