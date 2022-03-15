package com.godv.lgd.dao;

/**
 * @program: lgd
 * @description:
 * @author: GodV
 * @create: 2021-11-23 17:26
 **/

public class PersonPlus extends Person implements PersonSelf{

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
