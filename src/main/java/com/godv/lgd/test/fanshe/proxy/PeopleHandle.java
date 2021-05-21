package com.godv.lgd.test.fanshe.proxy;

import com.godv.lgd.test.fanshe.dao.People;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: lgd
 * @description: people代理类
 * proxy代理 目标类必须是实现接口
 * 通过jdk在api的运行期间,动态生成代理对象
 *
 * 装饰者模式获得原targe
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
