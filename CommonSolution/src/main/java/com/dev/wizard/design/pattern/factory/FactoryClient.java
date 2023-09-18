package com.dev.wizard.design.pattern.factory;

public class FactoryClient {

    public Car createCar(String carType){
        if(carType.equals("BYDCar")){
            return new BYDCar();
        }else if(carType.equals("TeslaCar")){
            return new TeslaCar();
        }else {
            return null;
        }
    }
}
