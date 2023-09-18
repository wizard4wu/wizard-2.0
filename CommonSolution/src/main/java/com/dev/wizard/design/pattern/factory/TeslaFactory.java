package com.dev.wizard.design.pattern.factory;

public class TeslaFactory implements CarFactory{
    @Override
    public TeslaCar createCar() {
        return new TeslaCar();
    }
}
