package study.web.dto;

import lombok.Getter;
import study.validation.annotation.ExistCategories;
import study.validation.annotation.ExistRegion;

import java.util.List;

public class StoreRequestDTO {

    @Getter
    public static class JoinDto{
        String name;
        String address;
        Double score;
        @ExistRegion
        Long regionId;

    }
}