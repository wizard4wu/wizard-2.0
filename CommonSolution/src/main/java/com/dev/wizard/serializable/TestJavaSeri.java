package com.dev.wizard.serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestJavaSeri {

    public static void main(String[] args) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\wizard\\Desktop\\TestJavaSeri.txt");

        Integer number = 222;
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(number);
    }
}
