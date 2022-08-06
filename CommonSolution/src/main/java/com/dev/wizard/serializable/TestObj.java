package com.dev.wizard.serializable;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class TestObj implements Serializable {

    private static final long serialVersionUID = 323L;

    private String name;

    private int age;

    private List<String> testList;


    public static void main(String[] args) throws Exception {
        String value = "Hello World Json";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new FileOutputStream("C:\\Users\\wizard\\Desktop\\json.txt"), value);


        TestObj obj = new TestObj();
        obj.name = "Hello";
        obj.age = 3;
        obj.testList = new ArrayList<>(Arrays.asList("ha","he"));

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\wizard\\Desktop\\TestJavaSeri.txt");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(obj);

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\wizard\\Desktop\\test.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        TestObj test = (TestObj) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(test);
    }
}
