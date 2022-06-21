package com.dev.wizard.design.pattern.strategy;

public class StrategyContext {
    private Strategy strategy;

    public StrategyContext(Strategy strategy){
        this.strategy = strategy;
    }
    public void provideStrategy(){
        strategy.provideStrategy();
    }
}
