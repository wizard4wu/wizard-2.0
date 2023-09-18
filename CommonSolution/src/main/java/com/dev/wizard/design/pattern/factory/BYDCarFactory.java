package com.dev.wizard.design.pattern.factory;

public class BYDCarFactory implements CarAbstractFactory{
    @Override
    public Engine createEngine() {
        return new BYDEngine();
    }

    @Override
    public CarGlass createCarGlass() {
        return new BYDCarGlass();
    }

    public static class BYDEngine extends Engine{

    }
    public static class BYDCarGlass extends CarGlass{

    }
}
