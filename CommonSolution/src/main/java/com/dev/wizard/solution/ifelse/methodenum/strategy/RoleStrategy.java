package com.dev.wizard.solution.ifelse.methodenum.strategy;

import com.dev.wizard.solution.ifelse.methodenum.factory.Role;

public class RoleStrategy {
    private final Role role;

    public RoleStrategy(Role role) {
        this.role = role;
    }

    public void doActionByRole() {
        role.doAction();
    }
}
