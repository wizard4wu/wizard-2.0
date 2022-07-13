package com.dev.wizard.research.collection.domain;

import lombok.Data;

@Data
public class HashMapObject {

    private String name;


    public int hashCode(){
        return this.name.length();
    }

    public boolean equals(HashMapObject object){
        return this.getName().equals(object.getName());
    }

}
