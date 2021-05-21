package com.godv.lgd.test.fanshe.proxy;

import com.godv.lgd.test.fanshe.dao.Man;
import com.godv.lgd.test.fanshe.dao.People;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @program: lgd
 * @description:
 * @author: GodV
 * @create: 2021-05-20 09:20
 **/

public class FanSheTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.godv.lgd.test.fanshe.dao.Man");
        Method[] methods = aClass.getMethods();
        Arrays.stream(methods).forEach(e->{
            System.out.println(e.getName());
        });
    }


    @Test
    public void test01(){
        People man = new Man();
        PeopleHandle peopleHandle = new PeopleHandle(man);
        People proxyInstance = (People)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{People.class}, peopleHandle);
        proxyInstance.sayBye();
        proxyInstance.sayHello();
    }
}
