package com.dev.wizard.extend;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ImplementPerson extends AbstractPerson{

    public Parent getPerson(boolean flag){
        if(flag){
           return super.getData();
        }else {
           return this.getData();
        }
    }

    Son getData(){
        log.info("ImplementPerson + Son");
        return new Son();
    }
}
