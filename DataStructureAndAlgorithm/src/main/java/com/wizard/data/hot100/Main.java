package com.wizard.data.hot100;

public class Main {


    enum ChangeType{
        ADD("added");
        private String typeValue;

        ChangeType(String typeValue){
            this.typeValue = typeValue;
        }

    }

}
