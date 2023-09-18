package com.dev.wizard.design.pattern.factory;

public class TeslaCarFactory implements CarAbstractFactory{
    @Override
    public Engine createEngine() {
        return new TeslaEngine();
    }

    @Override
    public CarGlass createCarGlass() {
        return new TeslaCarGlass();
    }


    public static class TeslaEngine extends Engine{

    }
    public static class TeslaCarGlass extends CarGlass{

    }
}
