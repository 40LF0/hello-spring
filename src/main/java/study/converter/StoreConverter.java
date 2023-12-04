package study.converter;

import study.common.Gender;
import study.domain.Member;
import study.domain.Store;
import study.web.dto.MemberRequestDTO;
import study.web.dto.MemberResponseDTO;
import study.web.dto.StoreRequestDTO;
import study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class StoreConverter {
    public static StoreResponseDTO.JoinResultDTO toJoinResultDTO(Store store) {
        return StoreResponseDTO.JoinResultDTO.builder()
                .storeId(store.getStoreId())
                .createdAt(store.getCreatedAt())
                .build();
    }

    public static Store toStore(StoreRequestDTO.JoinDto request) {
        return Store.builder()
                .address(request.getAddress())
                .score(request.getScore())
                .name(request.getName())
                .build();
    }

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getMemberId())
                .createdAt(LocalDateTime.now())
                .build();
    }


}