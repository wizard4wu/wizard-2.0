package com.dev.wizard.serializable;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileOutputStream;
import java.io.IOException;

public class TestJson {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String value = "Hello World Json";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new FileOutputStream("C:\\Users\\wizard\\Desktop\\JsonTest.txt"), value);
        System.out.println("Finish");
    }
}