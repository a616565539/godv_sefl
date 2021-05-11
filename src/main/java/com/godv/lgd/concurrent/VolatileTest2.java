package com.godv.lgd.concurrent;

import com.godv.lgd.Person;

public class VolatileTest2 {


    public static void main(String[] args) throws InterruptedException {


        Person s = new Person();

        new Thread(()->{
            try {
                System.out.println("t1开始");
                System.out.println(Thread.currentThread());
                Thread.sleep(2000L);
                s.setName("已修改");
                Thread.sleep(5000L);
                System.out.println("t1结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(1000L);
        new Thread(()->{
                System.out.println("t2开始");
            System.out.println(Thread.currentThread());
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(s.getName());
            System.out.println("t2结束");
        }).start();

        Thread.sleep(1000L);
        System.out.println(s.getName());
        Thread.sleep(100000);
    }


}
