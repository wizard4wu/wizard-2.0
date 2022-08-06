package com.dev.wizard.iostream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class IODemo {

    public static void main(String[] args) {
        openIOStreamWithOutClose();
    }

    public static void openIOStreamWithOutClose() {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
             fileOutputStream = new FileOutputStream("C:\\Users\\wizard\\Desktop\\合同协议书.docx");
             objectOutputStream = new ObjectOutputStream(fileOutputStream);

             objectOutputStream.close();
            System.out.println("........");
            throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void openIOStreamWithClose() {
        try ( FileOutputStream fileOutputStream  = new FileOutputStream("C:\\Users\\wizard\\Desktop\\合同协议书.docx");
               ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);) {
            System.out.println("hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
