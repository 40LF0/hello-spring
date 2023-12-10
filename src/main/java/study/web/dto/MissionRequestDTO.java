package study.web.dto;

import lombok.Getter;
import study.common.validateAnotation.annotation.ExistStore;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class MissionJoinDto {
        Long missionId;
        Long reward;
        LocalDate deadline;
        String missionSpec;
        @ExistStore
        Long storeId;
    }
}