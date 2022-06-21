package com.dev.wizard.design.pattern.strategy;

public class StrategyObjectOne implements Strategy{
    @Override
    public void provideStrategy() {
        System.out.println("StrategyMethodOne");
    }
}
