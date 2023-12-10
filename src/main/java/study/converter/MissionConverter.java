package study.converter;

import study.domain.Mission;
import study.domain.Review;
import study.web.dto.MissionRequestDTO;
import study.web.dto.MissionResponseDTO;
import study.web.dto.ReviewRequestDTO;
import study.web.dto.ReviewResponseDTO;

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

}