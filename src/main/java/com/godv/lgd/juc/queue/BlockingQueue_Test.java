package com.godv.lgd.juc.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueue_Test {

    static char[] c1 = "123456".toCharArray();
    static char[] c2 = "abcdef".toCharArray();

    public static void main(String[] args) {

    }


    //AQS
    void abq() {
        BlockingQueue queue1 = new ArrayBlockingQueue(1);
        BlockingQueue queue2 = new ArrayBlockingQueue(1);
        new Thread(() -> {
            try {
                for (char c : c1) {
                    queue1.take();
                    queue2.put("ok");
                    System.out.println(c);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (char c : c2) {
                    queue1.put("ok");
                    queue2.take();
                    System.out.println(c);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
