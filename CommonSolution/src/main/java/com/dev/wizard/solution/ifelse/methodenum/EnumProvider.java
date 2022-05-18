package com.dev.wizard.solution.ifelse.methodenum;

import java.util.EnumSet;

public interface EnumProvider<T extends Enum<T>> {

    EnumSet<T> getEnumSet();
}
