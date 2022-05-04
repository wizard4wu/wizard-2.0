package com.dev.wizard.check.duplicate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Documented
@Constraint(
        // 自定义校验器 校验集合中重复的元素
        validatedBy = {DuplicatedElementValidation.class}
)
public @interface NotDuplicatedElement {

    String message() default "{not_duplicated_element}";

    boolean ignoreCase() default false;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
