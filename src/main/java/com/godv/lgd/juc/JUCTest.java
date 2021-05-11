package com.godv.lgd.juc;

import com.godv.lgd.TestDao;
import org.junit.Test;

import java.util.concurrent.Callable;

public class JUCTest {

    @Test
    public void daoTest(){
        TestDao build = TestDao.builder().one("1").two("2").three("3").build();
        TestOne(build);
        System.out.println(build);
    }

    private void TestOne(TestDao b){
        b = TestDao.builder().one("2").two("1").three("5").build();
    }

    @Test
    public void equalsTest(){
        TestDao build = TestDao.builder().one("1").two("2").three("3").build();
        TestDao build2 = TestDao.builder().one("1").two("2").three("3").build();
        System.out.println(build.equals(build2));

    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println( );
    }



}
