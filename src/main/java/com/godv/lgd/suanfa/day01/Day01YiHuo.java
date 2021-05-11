package com.godv.lgd.suanfa.day01;

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
                result1 ^=  arr[i];
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
}
