package com.dev.wizard.design.pattern.factory;

public class BYDFactory implements CarFactory{
    @Override
    public BYDCar createCar() {
        return new BYDCar();
    }
}
