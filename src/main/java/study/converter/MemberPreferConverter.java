package study.converter;

import study.domain.Category;
import study.domain.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPreferList(List<Category> categoryList){

        return categoryList.stream()
                .map(category ->
                        MemberPrefer.builder()
                                .category(category)
                                .build()
                ).collect(Collectors.toList());
    }
}
