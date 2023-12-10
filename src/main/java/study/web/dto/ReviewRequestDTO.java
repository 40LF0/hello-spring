package study.web.dto;

import lombok.Getter;
import study.common.validateAnotation.annotation.ExistStore;

import java.util.List;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewJoinDto {
        String body;
        Double score;
        Long memberId;
        @ExistStore
        Long storeId;
        List<String> imageUrlList;

    }
}