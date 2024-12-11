package com.dev.wizard.clazz;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class CustomClassLoadDemo extends ClassLoader{

    public CustomClassLoadDemo(){
        System.out.println("CustomClassLoadDemo + Constructor");
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException{
        File file = new File("D:\\test\\People.class");
        try {
            byte[] bytes = getClassBytes(file);
            return this.defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] getClassBytes(File file) throws Exception {
        // 这里要读入.class的字节，因此要使用字节流
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel wbc = Channels.newChannel(baos);
        ByteBuffer by = ByteBuffer.allocate(1024);

        while (true){
            int i = fc.read(by);
            if (i == 0 || i == -1)
                break;
            by.flip();
            wbc.write(by);
            by.clear();
        }
        fis.close();
        return baos.toByteArray();
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        CustomClassLoadDemo classLoadDemo = new CustomClassLoadDemo();
        Class clazz = Class.forName("People", true, classLoadDemo);
        Object ojb = clazz.newInstance();
        Person person = new Person("test", 3);
        person.age();

    }
}
