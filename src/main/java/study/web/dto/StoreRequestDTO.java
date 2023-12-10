package study.web.dto;

import lombok.Getter;
import study.validation.annotation.ExistRegion;

public class StoreRequestDTO {
    @Getter
    public static class StoreJoinDTO {
        String name;
        String address;
        Double score;
        @ExistRegion
        Long regionId;
    }

    @Getter
    public static class ReviewDTO {
        Double score;
        String body;
    }
}