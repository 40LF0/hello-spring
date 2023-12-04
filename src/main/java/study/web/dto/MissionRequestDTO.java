package study.web.dto;

import lombok.Getter;
import study.domain.Store;
import study.validation.annotation.ExistCategories;
import study.validation.annotation.ExistStore;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.List;

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