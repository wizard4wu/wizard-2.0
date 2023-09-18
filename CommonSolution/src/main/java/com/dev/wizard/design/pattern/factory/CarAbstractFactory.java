package com.dev.wizard.design.pattern.factory;

import org.apache.catalina.startup.EngineRuleSet;

public interface CarAbstractFactory {

    Engine createEngine();

    CarGlass createCarGlass();

    public static class Engine{

    }
    public static class CarGlass{

    }
}

