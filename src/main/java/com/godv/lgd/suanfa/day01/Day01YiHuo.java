package com.godv.lgd.suanfa.day01;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Day01YiHuo {

    public static void oneNumber(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result ^= arr[i];
        }
        System.out.println(result);
    }


    public static void twoNumber(int[] arr) {
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            temp ^= arr[i];
        }
        int err = temp & (~temp + 1);

        int result1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((err & arr[i]) != 0) {
                result1 ^= arr[i];
            }
        }

        System.out.println(result1 + "" + (result1 ^ temp));
    }


    public static void main(String[] args) {
        int[] arr1 = {3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1};
        oneNumber(arr1);

        int[] arr2 = {4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2};
        twoNumber(arr2);
    }

    @Test
    public void test01() {

        List<Integer> integers = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 1000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(16));
        List<CompletableFuture<Integer>> collect = integers.stream().map(e ->
                CompletableFuture.supplyAsync(() -> getInt(), threadPoolExecutor)).collect(Collectors.toList());

        List<Integer> collect1 = collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
        int total = collect1.parallelStream().mapToInt(e -> e).sum();
        System.out.println(total);
    }

    public Integer getInt() {
        System.out.println(Thread.currentThread().getName());
        return 5;
    }
}
