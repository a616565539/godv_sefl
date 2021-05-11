package com.godv.lgd;

public class Person {


    private String name ="初始化";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
        System.out.println("wai");
    }

    class innerPerson{
        public innerPerson() {
            System.out.println("nei");
        }
    }
}
