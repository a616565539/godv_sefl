package com.godv.lgd.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2,
                60l, TimeUnit.SECONDS, new ArrayBlockingQueue<>(8));
        threadPoolExecutor.execute(new Thread(()->{
            System.out.println("66666");
        }));

    }
}
