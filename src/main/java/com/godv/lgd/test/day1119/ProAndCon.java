package com.godv.lgd.test.day1119;


import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 消费者和生产者
 */
public class ProAndCon {

    private LinkedList list = new LinkedList();
    private int MAX_SIZE = 10;
    private int poolSize = 0;

    private Lock lock= new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public synchronized void add() throws InterruptedException {
        while(poolSize==MAX_SIZE){
            this.wait();
            lock.lock();
        }
        poolSize++;
    }

    public synchronized void get() throws InterruptedException {
        while(poolSize==MAX_SIZE){
            this.wait();
        }
        poolSize--;

    }
}
