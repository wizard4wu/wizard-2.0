package com.dev.wizard.serializable;


import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonDemo {
    public static void main(String[] args) throws JsonProcessingException {

        Student student = new Student();
        student.setAge(12);
        student.setName("xiaoming");

        //fastjson
        String value = JSON.toJSONString(student);
        System.out.println("fastjson:" + value);

        //jackson
        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writeValueAsString(student);
        System.out.println("jackson:" + str);
    }
    @Data
    public static class Student{

        private int age;
        private String name;

        public String getData(){
            log.info("Student + getData");
            return "hello";
        }
        public void setData(){
            log.info("Student + setData");
        }

        public boolean isAdult(){
            log.info("Student + isSuccess");
            return this.age >= 19;
        }
    }
    /**
     *  get  ---> retrive
     *  set  ---> init
     *  is   ---> enable, from
     */
}
