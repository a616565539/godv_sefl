package com.godv.lgd.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class day01 {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application.yaml");
        Object person = classPathXmlApplicationContext.getBean("person");
        System.out.println(person);
    }
}
