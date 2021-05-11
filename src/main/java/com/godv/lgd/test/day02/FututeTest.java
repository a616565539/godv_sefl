package com.godv.lgd.test.day02;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 11.15
 * 11.16
 */
public class FututeTest {

    public static void main(String[] args) {
//        CompletableFuture.supplyAsync(() ->  1).thenAccept(result -> result.
    }


    @Data
    @Builder
    @AllArgsConstructor
    private static class MyTaks {
        private String name;
        private Boolean isSuccess;
        private int timeOut;
    }

}
