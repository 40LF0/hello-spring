package study.common.validateAnotation.annotation;

import study.common.validateAnotation.validator.CheckPageValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.Valid;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckPageValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    String message() default "올바르지 않은 페이지 번호 입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
