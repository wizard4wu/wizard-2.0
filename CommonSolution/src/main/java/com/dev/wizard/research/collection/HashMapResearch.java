package com.dev.wizard.research.collection;

import com.dev.wizard.research.collection.domain.HashMapObject;

import java.util.HashMap;
import java.util.Map;

public class HashMapResearch {


    public static void main(String[] args) {


        Map<HashMapObject, String> hashMap = new HashMap<>();

        HashMapObject hashMapObject = new HashMapObject();
        hashMapObject.setName("Test1");
        hashMap.put(hashMapObject, "1");

        HashMapObject hashMapObject2 = new HashMapObject();
        hashMapObject2.setName("Test2");
        hashMap.put(hashMapObject2, "2");

        HashMapObject hashMapObject3 = new HashMapObject();
        hashMapObject3.setName("Test3");
        hashMap.put(hashMapObject3, "3");

        HashMapObject hashMapObject4 = new HashMapObject();
        hashMapObject4.setName("Test4");
        hashMap.put(hashMapObject4, "4");

        HashMapObject hashMapObject5 = new HashMapObject();
        hashMapObject5.setName("Test5");
        hashMap.put(hashMapObject5, "5");

        HashMapObject hashMapObject6 = new HashMapObject();
        hashMapObject6.setName("Test6");
        hashMap.put(hashMapObject6, "6");

        HashMapObject hashMapObject7 = new HashMapObject();
        hashMapObject7.setName("Test7");
        hashMap.put(hashMapObject7, "7");

        HashMapObject hashMapObject8 = new HashMapObject();
        hashMapObject8.setName("Test8");
        hashMap.put(hashMapObject8, "8");

        HashMapObject hashMapObject9 = new HashMapObject();
        hashMapObject9.setName("Test9");
        hashMap.put(hashMapObject9, "9");
    }
}
