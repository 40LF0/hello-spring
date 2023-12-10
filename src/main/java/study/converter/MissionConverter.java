package study.converter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import study.domain.MemberMission;
import study.domain.Mission;
import study.domain.Review;
import study.web.dto.MissionRequestDTO;
import study.web.dto.MissionResponseDTO;
import study.web.dto.ReviewRequestDTO;
import study.web.dto.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {
    public static MissionResponseDTO.MissionJoinResultDTO toJoinResultDTO(Mission mission) {
        return MissionResponseDTO.MissionJoinResultDTO.builder()
                .missionId(mission.getMissionId())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.MissionJoinDto request) {
        return Mission.builder()
                .missionSpec(request.getMissionSpec())
                .deadline(request.getDeadline())
                .reward(request.getReward())
                .build();
    }

    public static MissionResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission){
        return MissionResponseDTO.MissionPreViewDTO.builder()
                .missionId(mission.getMissionId())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .updateAt(mission.getUpdatedAt().toLocalDate())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .build();
    }
    public static MissionResponseDTO.MissionPreviewListDTO reviewPreViewListDTO(Page<Mission> missionList){

        List<MissionResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionPreviewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }

    public static Page<Mission> toMissionPageFromMemberMissionPage(Page<MemberMission> memberMissions) {
        List<Mission> missions = memberMissions.stream()
                .map(MemberMission::getMission)
                .collect(Collectors.toList());

        Pageable pageable = memberMissions.getPageable();

        return new PageImpl<>(missions, pageable, memberMissions.getTotalElements());
    }
}