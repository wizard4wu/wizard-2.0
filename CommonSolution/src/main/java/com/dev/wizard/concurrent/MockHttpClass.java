package com.dev.wizard.concurrent;

import lombok.SneakyThrows;

public class MockHttpClass {

    public static String mockHttpCall(String value) {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //  System.out.println("mockHttpCall..." + value);
        if("5".equals(value)){
            throw new UnsupportedOperationException();
        }
        return "return mockHttpCall" + value;
    }


}
