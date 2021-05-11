package com.godv.lgd.juc;


import com.godv.lgd.Person;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SyncTest<T> {

    final private ArrayList<T> list = new ArrayList<>();

    final private int MAX = 10;

    private int count = 0;



    public synchronized void put(T value){


        while(list.size()==MAX){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(value);
             
        }
    }

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("6666");
        }).start();


        new test01().run();
    }


    static class test01 implements Runnable{

        @Override
        public void run() {
            System.out.println("6666");
        }
    }

    static class test02{
        public static void main(String[] args) {
            ThreadLocal<Person> stringThreadLocal = new ThreadLocal<>();
            Person person = new Person();
            stringThreadLocal.set(person);
            System.out.println(person);
            System.out.println(stringThreadLocal);
            stringThreadLocal.remove();
        }
    }


    static class test03{
        public static void main(String[] args) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 1000L,
                    TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(8));
            threadPoolExecutor.execute(new Thread(()->{
                System.out.println("6666");
            }));
        }
    }

    static class test04{
        public static void main(String[] args) {

        }
    }

}
