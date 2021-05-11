package com.godv.lgd.juc;

import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedTest {

    private static AtomicInteger atomicInteger =new AtomicInteger(0);

    public static void main(String[] args) {
        atomicInteger.incrementAndGet();
    }
}
