package com.dev.wizard.solution.ifelse.methodenum;

public enum GenderEnum {

    FEMALE(0), MALE(1);

    private int value;

     GenderEnum(int value){
        this.value = value;
    }

    public int getValue(){
         return value;
    }
}
