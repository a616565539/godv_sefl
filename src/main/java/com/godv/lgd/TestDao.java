package com.godv.lgd;

import lombok.*;

import java.util.HashMap;

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
        System.out.println(2^2);
    }

    public TestDao() {
    }
}


