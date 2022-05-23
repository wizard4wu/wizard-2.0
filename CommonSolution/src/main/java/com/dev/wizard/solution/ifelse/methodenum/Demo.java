package com.dev.wizard.solution.ifelse.methodenum;

import com.dev.wizard.solution.ifelse.methodenum.factory.RoleFactory;

public class Demo {

    public static void main(String[] args) {

        //原始
        doActionByRole("teacher");

        //工厂模式实现
        RoleFactory.getRole("student").doAction();

    }

    public static void doActionByRole(String role){
        if(role.equals(RoleEnum.HEADMASTER_ROLE.getValue())){
            System.out.println("校长审作业");
        }else if(role.equals(RoleEnum.TEACHER_ROLE.getValue())){
            System.out.println("老师改作业");
        }else if(role.equals(RoleEnum.STUDENT_ROLE.getValue())){
            System.out.println("学生写作业");
        }else {
            System.out.println("");
        }
    }
}
