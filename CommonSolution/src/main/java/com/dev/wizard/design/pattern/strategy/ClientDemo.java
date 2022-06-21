package com.dev.wizard.design.pattern.strategy;

//行为模式之策略模式

//策略模式得关键是策略对象，不同的策略对象会执行不同的策略；接口只是抽象的策略那一层，具体执行什么样的策略得回到具体的实现类。
public class ClientDemo {
    public static void main(String[] args) {

        StrategyContext strategyContext1 = new StrategyContext(new StrategyObjectOne());
        strategyContext1.provideStrategy();

        StrategyContext strategyContext2 = new StrategyContext(new StrategyObjectTwo());
        strategyContext2.provideStrategy();
    }
}
