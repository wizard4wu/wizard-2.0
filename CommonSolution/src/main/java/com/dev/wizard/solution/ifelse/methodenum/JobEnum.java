package com.dev.wizard.solution.ifelse.methodenum;

import java.util.EnumSet;

public enum JobEnum implements EnumProvider {

    ENGINEER("engineer"), LEADER("leader"), MANAGER("Manager");


    private final String value;

    JobEnum(String value) {
        this.value = value;
    }

    @Override
    public EnumSet getEnumSet() {
        return null;
    }
}
