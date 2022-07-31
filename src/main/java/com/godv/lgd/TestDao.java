package com.godv.lgd;

import lombok.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentSkipListSet;

@Getter
@AllArgsConstructor
@Builder
@ToString
public class TestDao {

    private String one;

    private String two;

    private String three;

    public static void main(String[] args) {
        int i =1;
//        System.out.println(i="2".hashCode() ^ i>>>16);
//        System.out.println(2^2);
//        int i1 = (int) (Math.random() * 100 + 1);
//        System.out.println(i1);
        String a = String.format("%s2222", "a");
        ConcurrentSkipListSet<String> objects = new ConcurrentSkipListSet<>();
        boolean add = objects.add("222");
        boolean add1 = objects.add("222");
        System.out.println(add);
        System.out.println(add1);
    }


}


