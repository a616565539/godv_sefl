package com.godv.lgd.rpc;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspectJ {


    @Pointcut("execution (* com.godv.lgd.rpc..*.*(..))")
    public void aspectM(){}

    @Before("aspectM()")
    public void beforeA(){
        System.out.println("before");
    }

    @After("aspectM()")
    public void afterA(){
        System.out.println("after");
    }
}
