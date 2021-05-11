package com.godv.lgd;

import com.godv.lgd.dao.Good;
import com.godv.lgd.dao.LevelMappingVO;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class TBTest01 {

    private static volatile List list = new ArrayList<>();
    private static Object lock = new Object();

    

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    if (list.size() == 5) {
                        try {
                            lock.notify();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    list.add(new Object());
                    System.out.println("t1.size=" + list.size());
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (lock) {
                if (list.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2结束运行");
                lock.notify ();
            }

        }).start();
    }

    @Test
    public  void test0001(){
        LevelMappingVO levelMappingVO = new LevelMappingVO();
        levelMappingVO.setPrice(1.00);
        Good good = new Good();
        BeanUtils.copyProperties(levelMappingVO,good);
        System.out.println(good);
    }
}
