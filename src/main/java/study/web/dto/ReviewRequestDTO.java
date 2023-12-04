package study.web.dto;

import lombok.Getter;

import java.util.List;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewJoinDto {
        String body;
        Double score;
        Long memberId;
        Long storeId;
        List<String> imageUrlList;

    }
}