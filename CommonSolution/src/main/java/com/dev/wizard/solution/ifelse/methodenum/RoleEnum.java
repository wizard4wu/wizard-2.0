package com.dev.wizard.solution.ifelse.methodenum;


public enum RoleEnum implements RoleOperation {

    TEACHER_ROLE("teacher") {
        public void doSomething() {
            System.out.println("老师改作业");
        }

    },
    STUDENT_ROLE("student") {
        public void doSomething() {
            System.out.println("学生写作业");
        }

    },
    HEADMASTER("headmaster") {
        public void doSomething() {
            System.out.println("校长审作业");
        }

    };

    private String value;

    RoleEnum(String value) {
        this.value = value;
    }
    //所有角色都会调用该方法
    public void doThing() {
        System.out.println("校长审作业");
    }

    public static void main(String[] args) {
        RoleEnum.HEADMASTER.doSomething();
    }
}
