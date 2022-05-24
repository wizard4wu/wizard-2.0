package com.dev.wizard.solution.ifelse.methodenum;

import com.google.common.collect.ImmutableMap;

import java.util.Collections;
import java.util.Map;

public enum NameEnum {

    ZHANG_SAN("张三") {
        public void doAction() {
            System.out.println("我是张三");
        }
    }, LI_SI("李四") {
        @Override
        public void doAction() {
            System.out.println("我是李四");
        }
    }, WANG_WU("王五") {
        @Override
        public void doAction() {
            System.out.println("我是王五");
        }
    }, ZHAO_QI("赵七") {
        @Override
        public void doAction() {
            System.out.println("我是赵七");
        }
    }, TIAN_BA("田八") {
        @Override
        public void doAction() {
            System.out.println("我是田八");
        }
    };

    private static final Map<String, NameEnum> NAME_ENUM_MAP = Collections.unmodifiableMap(ImmutableMap.<String, NameEnum>builder()
            .put(ZHANG_SAN.getValue(), ZHANG_SAN)
            .put(LI_SI.getValue(), LI_SI)
            .put(WANG_WU.getValue(), WANG_WU)
            .put(ZHAO_QI.getValue(), ZHAO_QI)
            .put(TIAN_BA.getValue(), TIAN_BA)
            .build());

    private final String name;

    NameEnum(String name) {
        this.name = name;
    }

    public String getValue() {
        return this.name;
    }

    public abstract void doAction();


    public static void main(String[] args) {
        NAME_ENUM_MAP.get("田八").doAction();
    }

}
