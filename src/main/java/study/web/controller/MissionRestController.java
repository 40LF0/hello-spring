package study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.common.apiResponse.ApiResponse;
import study.converter.MissionConverter;
import study.converter.ReviewConverter;
import study.domain.Mission;
import study.domain.Review;
import study.service.MissionCommandService;
import study.service.ReviewCommandService;
import study.web.dto.MissionRequestDTO;
import study.web.dto.MissionResponseDTO;
import study.web.dto.ReviewRequestDTO;
import study.web.dto.ReviewResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.MissionJoinResultDTO> join(@RequestBody @Valid MissionRequestDTO.MissionJoinDto request){
        Mission mission = missionCommandService.joinMission(request);
        return ApiResponse.onSuccess(MissionConverter.toJoinResultDTO(mission));
    }
}
