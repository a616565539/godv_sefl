package com.godv.lgd.juc;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class TickSell {

    private static AtomicInteger idex = new AtomicInteger();

    private static Queue<String> ticks = new ConcurrentLinkedDeque<String>();
    static{
        for(int i =0;i<10000;i++){
            ticks.add(String.format("第%s张票",i));
        }
    }

    public static void main(String[] args) {
        for (int i =0;i<10;i++){
            new Thread(() -> {

                while (ticks.size()>0){
                    if(ticks.size()==1){
                        System.out.println(idex.getAndIncrement());
                    }
                    String poll = ticks.poll();
                    System.out.println("卖出了"+ poll);
                    idex.getAndIncrement();

                }
            }).start();
        }
    }
}
