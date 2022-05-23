package com.dev.wizard.solution.ifelse.methodenum.factory;

import com.dev.wizard.solution.ifelse.methodenum.RoleEnum;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class RoleFactory {
    private static final Map<String, Role> ROLE_MAP = ImmutableMap.<String, Role>builder()
            .put(RoleEnum.TEACHER_ROLE.getValue(), new TeacherRole())
            .put(RoleEnum.STUDENT_ROLE.getValue(), new StudentRole())
            .put(RoleEnum.HEADMASTER_ROLE.getValue(), new HeadermasterRole())
            .build();

    public static Role getRole(String name) {
        return ROLE_MAP.getOrDefault(name, null);
    }
}
