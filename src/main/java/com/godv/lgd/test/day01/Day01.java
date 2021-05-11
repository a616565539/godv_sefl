package com.godv.lgd.test.day01;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Day01 {


    private class MyThread1 extends Thread{
        @Override
        public void run() {
            System.out.println("继承线程方法");
        }
    }

    private class MyThread2 implements Runnable{
        @Override
        public void run() {
            System.out.println("实现Runnable接口方法");

        }
    }

    private class ThreadCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            System.out.println("futureTask方式启动线程");
            System.out.println(Thread.currentThread().getName());
            return 1;
        }
    }

    @Test
    public void runnable(){
/*        MyThread1 myThread1 = new MyThread1();
        myThread1.start();*/

/*        MyThread2 thread = new MyThread2();
        new Thread(thread).start();*/

/*        System.out.println("66666");
        System.out.println("66666");*/


        FutureTask<Integer> integerFutureTask = new FutureTask<>(new ThreadCallable());
        new Thread(integerFutureTask).start();

        try {
            Integer integer = integerFutureTask.get();
            System.out.println(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    private static Object szObject = new Object();
    private static Object zmObject = new Object();

    private static class soutSz extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            for (int i=1;i<26;i++){
                synchronized (szObject){
                    System.out.println(i);
                    zmObject.notifyAll();
                    szObject.wait();
                }
            }
        }
    }

    private static class soutZm extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            for (int i=1;i<26;i++){
                synchronized (zmObject){
                    System.out.println(i+100);
                    szObject.notifyAll();
                    zmObject.wait();
                }
            }
        }
    }

    @Test
    public void testSout(){
        new Thread(new soutSz()).start();
        new Thread(new soutZm()).start();

    }
}
