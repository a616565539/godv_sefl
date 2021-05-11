package com.godv.lgd.test.day1119;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 售票
 */
public class TicketSell {

    public static AtomicInteger ticketNumber= new AtomicInteger(1000) ;

    public static void sellTicket(){
        ticketNumber.decrementAndGet();
        System.out.println(ticketNumber);
    }


    public static void main(String[] args) {
        for(int i=1;1<10000;i++) {
            new Thread(() -> sellTicket()).start();

        }
    }
}
