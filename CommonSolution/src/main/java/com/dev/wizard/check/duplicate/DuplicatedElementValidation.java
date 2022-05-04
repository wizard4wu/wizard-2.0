package com.dev.wizard.check.duplicate;


import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class DuplicatedElementValidation implements ConstraintValidator<NotDuplicatedElement, Collection<?>> {

    private boolean ignoreCase = false;

    @Override
    public void initialize(NotDuplicatedElement constraintAnnotation) {
        ignoreCase = constraintAnnotation.ignoreCase();

    }

    @Override
    public boolean isValid(Collection<?> value, ConstraintValidatorContext context) {

        if (CollectionUtils.isEmpty(value)) {
            return true;
        }
        Object obj = value.iterator().next();
        if (obj instanceof String) {
            if (ignoreCase) {
                value = value.stream().map(v -> StringUtils.lowerCase((String) v)).collect(Collectors.toList());
            }
        }
        Set set = new HashSet<>(value);
        return set.size() == value.size();
    }
}