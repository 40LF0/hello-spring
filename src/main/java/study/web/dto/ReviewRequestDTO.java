package study.web.dto;

import lombok.Getter;
import study.validation.annotation.ExistStore;

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