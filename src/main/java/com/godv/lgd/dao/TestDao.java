package com.godv.lgd.dao;

/**
 * @program: lgd
 * @description:
 * @author: GodV
 * @create: 2021-11-23 17:27
 **/

public class TestDao {
    public static void main(String[] args) {
        Person person = new PersonPlus();
        person.setName("11");
        person.setScore(100.00);
        PersonPlus personPlus = (PersonPlus)person;
        personPlus.setAge(18);
        Person person1= personPlus;

        System.out.println(person instanceof PersonSelf);

    }
}
