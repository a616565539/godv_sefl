package com.godv.lgd.concurrent;

import com.godv.lgd.Person;
import com.godv.lgd.TestDao;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class VolatileTest {

    volatile vision t1 = new vision();

    public static void main(String[] args) throws InterruptedException {
        Person s = new Person();


        new Thread(()->{
            System.out.println("t2开始");
            while (true) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread());
                System.out.println(s.getName());
            }
        }).start();

        Thread.sleep(2000L);
        new Thread(()->{
                System.out.println("t1开始");
                System.out.println(Thread.currentThread());
                s.setName("已修改");
                System.out.println("t1结束");
        }).start();



        Thread.sleep(100000);
    }




    class vision extends Thread {
        private boolean flag = false;

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            flag = true;
        }
    }

    @Test
    public void demo01() throws InterruptedException {
        //子线程启动
        vision t1 = new vision();
        t1.start();

        //主线程
        for (;;){
            System.out.println(t1.isFlag());
            Thread.sleep(1000);
        }
    }


    @Test
    public void demo02() throws InterruptedException {
        //子线程启动

        t1.start();

        //主线程
        while(true){
            if (t1.isFlag()){
                System.out.println(t1.isFlag());
                Thread.sleep(1000);
            }
        }
    }

    @Test
    public void optionalTest(){
//        TestDao testDao = new TestDao();
//        ArrayList<Object> objects = new ArrayList<>();
//        objects =null;
//        boolean present = Optional.ofNullable(objects).isPresent();
//        System.out.println(present);
    }

    @Test
    public void parallelTest(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<String> collect = integers.parallelStream().map(Objects::toString).collect(Collectors.toList());
        System.out.println(collect);
    }
}
