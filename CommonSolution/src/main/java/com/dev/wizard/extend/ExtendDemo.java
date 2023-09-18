package com.dev.wizard.extend;

public class ExtendDemo {

    public Parent getData(boolean fromSon){

        if(fromSon){
            Son son = new Son();
            son.setId("id");
            son.setAge(12);
            son.setSchoolAddress("zhongguo");
            return son;
        }else {
            Parent parent = new Parent();
            parent.setId("pId");
            parent.setAge(32);
            return parent;
        }
    }

    public static void main(String[] args) {
        ExtendDemo extendDemo = new ExtendDemo();
        //ystem.out.println(extendDemo.getData(false));
        ImplementPerson implementPerson = new ImplementPerson();
        implementPerson.getPerson(true);
    }
}
