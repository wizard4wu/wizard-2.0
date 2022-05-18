package com.dev.wizard.research.proxy.mock;

import com.dev.wizard.research.proxy.domain.People;
import com.google.common.eventbus.Subscribe;

public class Teacher extends People {

    public void teacher(String name) {
        System.out.println(name + "在上课");
    }

    @Override
    public void sleep() {
        System.out.println("Public Teacher sleep");
    }

    private void play(String name) {
        //都是通过代理类去访问的，代理类对public方法生成放好然后使用this.target调用目标类的方法
        System.out.println(name + "在玩耍");
    }
}
