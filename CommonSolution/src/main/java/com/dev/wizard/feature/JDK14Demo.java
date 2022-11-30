package com.dev.wizard.feature;

public class JDK14Demo {


    public static void textBlock() {

        //1.支持文本块
        String text = """
                {
                "value":"Hello World",
                "result":"data";
                }
                """;
        String s = "  {\n" +
                "                \"value\":\"Hello World\",\n" +
                "                \"result\":\"data\";\n" +
                "                }";
        System.out.println(text);

        //2.instance of类型转换
        /**
         * instance of增强
         */

        Object value = "abc";
        if (value instanceof String newValue) {
            System.out.println(newValue.length());
        }

        if (value instanceof String newValue) {
            System.out.println(newValue.length());
        }

    }

    public static void instanceofMethod() {
        //before
        Object value = "abc";
        if (value instanceof String) {
            String newValue = (String) value;
            System.out.println(newValue.length());
        }

        //after
        if (value instanceof String newValue) {
            System.out.println(newValue.length());
        }
    }

    public static void main(String[] args) {
        textBlock();
    }
}
