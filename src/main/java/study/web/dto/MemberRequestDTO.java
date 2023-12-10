package study.web.dto;

import lombok.Getter;
import study.common.validateAnotation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class MemberJoinDto {
        String name;
        Integer gender;
        Integer birthYear;
        Integer birthMonth;
        Integer birthDay;
        String address;
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
    }
}