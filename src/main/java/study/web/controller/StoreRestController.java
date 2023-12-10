package study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.common.apiResponse.ApiResponse;
import study.converter.StoreConverter;
import study.domain.Store;
import study.service.StoreCommandService;
import study.web.dto.StoreRequestDTO;
import study.web.dto.StoreResponseDTO;


import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.StoreJoinResultDTO> join(@RequestBody @Valid StoreRequestDTO.StoreJoinDto request){
        Store store = storeCommandService.joinStore(request);
        return ApiResponse.onSuccess(StoreConverter.toJoinResultDTO(store));
    }
}
