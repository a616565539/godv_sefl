package com.godv.lgd.sf.test;

import com.godv.lgd.sf.dao.Node;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;


public class dai01 {

    public static void main(String[] args) {
    }

    Node<Integer> dx(Node<Integer> head){


        while (head!=null){

        }

        return head;
    }

    @Test
    public void test01(){
        HashSet<testSet> testSets = new HashSet<>();
        testSet testSet = new testSet();
        testSets.add(new testSet());
        testSets.add(testSet);
        testSets.add(testSet);
        testSets.stream().forEach(System.out::println);
    }

    private class testSet{


        @Override
        public int hashCode() {
            return 5;
        }
    }


    @Test
    public void tstest(){
        ts01();
    }

    @Transactional
    public void ts01(){
        ts02();
        System.out.println("66666");
    }

    @Transactional
    public void ts02()  {
        int i =1/0;
    }
}
