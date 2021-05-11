package com.godv.lgd.rpc;


import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Optional;

@RestController
public class TestRpc {

    @GetMapping("/test")
    public void test(){
        System.out.println("hello");
        ts01();
    }

    @Transactional
    public void ts01(){
        ts02();
        System.out.println("66666");
    }

    @Transactional
    public void ts02()  {
        int i =1/0;
    }


    @Test
    public void test001() throws InterruptedException {
//        UserAspectJ.class.getDeclaredMethods()[0].isAnnotationPresent()
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        for (;;) {
            Thread.sleep(100);
            objectObjectHashMap.put("name", "a");
            System.out.println(objectObjectHashMap.putIfAbsent("name", "b"));
            System.out.println(objectObjectHashMap.putIfAbsent("name", "c"));
        }


    }

}
