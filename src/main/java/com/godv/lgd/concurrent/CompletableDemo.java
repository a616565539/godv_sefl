package com.godv.lgd.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> thread1());
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            int i = 0;
            try {
                i = thread2();
                return i;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return i;
        });
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> thread3());

        Void join = CompletableFuture.allOf(future1, future2, future3).join();
        Integer integer = future1.get();
        System.out.println(join);
    }

    public static int thread1(){
        System.out.println("线程1执行完毕");
        return 1;
    }
    public static int thread2() throws InterruptedException {
        Thread.sleep(5000L);
        System.out.println("线程2执行完毕");
        return 2;
    }
    public static int thread3(){
        System.out.println("线程3执行完毕");
        return 3;
    }
}
