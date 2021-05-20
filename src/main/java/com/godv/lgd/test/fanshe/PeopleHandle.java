package com.godv.lgd.test.fanshe;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: lgd
 * @description: people代理类
 * @author: GodV
 * @create: 2021-05-20 11:08
 **/

public class PeopleHandle implements InvocationHandler {

    private People people;

    public PeopleHandle(People people) {
        super();
        this.people = people;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = null;
        if (method.getName().equals("sayHello")) {
            System.out.println("男人前增强");
        }
        invoke = method.invoke(people, args);

        if (method.getName().equals("sayHello")) {
            System.out.println("男人后增强");
        }
        return invoke;
    }
}
