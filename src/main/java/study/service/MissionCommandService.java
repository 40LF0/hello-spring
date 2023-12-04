package study.service;

import study.domain.Mission;
import study.domain.Review;
import study.web.dto.MissionRequestDTO;
import study.web.dto.ReviewRequestDTO;

public interface MissionCommandService {
    public Mission joinMission(MissionRequestDTO.MissionJoinDto request);
}
