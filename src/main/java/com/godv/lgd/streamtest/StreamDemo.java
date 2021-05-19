package com.godv.lgd.streamtest;

import com.alibaba.nacos.api.utils.StringUtils;
import com.godv.lgd.dao.Good;
import com.godv.lgd.dao.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        String[] string = {"dat", "tda", "tan", "atd", "nat", "bat", "dat", "tda", "tan", "atd", "nat", "bat"};
        List<String> strings = Arrays.asList(string);
        Stream<String> stream = strings.stream();

        //多线程stream
        strings.parallelStream().forEach(e -> test01(e));

        //单线程
        strings.stream().forEach(StreamDemo::test01);


    }

    private static void test01(String s) {
        System.out.println("线程id为" + Thread.currentThread().getName());
    }

    @Test
    public  void test02() {
        ArrayBlockingQueue<String> cList = new ArrayBlockingQueue<String>(1);
        cList.add("a");
        cList.add("a");
        cList.add("a");
        cList.add("a");
    }


    @Test
    public void concurrentList() {
        List<String> strings = Arrays.asList(new String[]{"a", "b", "c", "d", "e", "a", "b", "c", "d", "e", "a", "b", "c", "d", "e"});
        System.out.println(strings);
        ArrayList<String> list = new ArrayList<>();

        ArrayBlockingQueue<String> cList = new ArrayBlockingQueue<String>(1000);

        AtomicInteger atomicInteger = new AtomicInteger(0);
        strings.parallelStream().forEach(e ->{
            list.add(atomicInteger.intValue(),e);
            int andIncrement = atomicInteger.getAndIncrement();

        });
        System.out.println(list);
    }



    @Test
    public void distinctAndSort() {
        List<String> strings = Arrays.asList(new String[]{"a", "b", "c", "d", "e", "a", "b", "c", "d", "e", "a", "b", "c", "d", "e"});

//        List<String> collect = strings.parallelStream()
//                .distinct()
//                .sorted(Comparator.comparing())
//                .collect(Collectors.toList());


    }

    @Test
    public void streamTest() {


        List<String> strings = Arrays.asList(new String[]{ "b", "c", "d", "e","a"});
        Stream<String> stringStream = strings.parallelStream();
        stringStream.filter(e -> e.equals("b"));
        List<String> collect = stringStream.sorted().collect(Collectors.toList());

        System.out.println(collect);
    }



    @Test
    public void streamSorted() {
        Person person1 = new Person("zhangsan",100.00);
        Person person2 = new Person("lisi",98.00);
        Person person3 = new Person("wangmazi",97.00);
        Person person4 = new Person("wangwu",96.00);
        List<Person> peopleList = Arrays.asList(person4,person3,person1, person2 );

        List<Person> collect = peopleList.stream().sorted((p1, p2) -> p1.getScore() > p2.getScore() ? 1 : -1).collect(Collectors.toList());
        System.out.println(collect);

    }



    @Test
    public void paralleStreamTotal() {
        Good good1 = new Good(100.00,"苹果");
        Good good2 = new Good(100.00,"香蕉");
        Good good3 = new Good(100.00,"水果");
        Good good4 = new Good(100.00,"蔬菜");
        Good good5 = new Good(100.00,"蔬菜");
        Good good6 = new Good(100.00,"蔬菜");
        Good good7 = new Good(100.00,"蔬菜");
        Good good8 = new Good(100.00,"蔬菜");
        List<Good> goods = Arrays.asList(good1, good2, good3, good4, good5, good6, good7, good8);

        AtomicReference<Double> total = new AtomicReference<>( 0.00);
        goods.parallelStream().forEach(
                p ->{
                    double score = p.getPrice();
                    total.updateAndGet(v -> new Double((v + score)));
                }
        );
        System.out.println(total.toString());
    }


    @Test
    public  void test04(){

        String[] split = "abcd".split("");
        List<String> strings = Arrays.asList(split);
        System.out.println(strings);

    }


    @Test
    public  void threadTest01() throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition producer = reentrantLock.newCondition();
        Condition consumer = reentrantLock.newCondition();
        producer.await();
    }


    @Test
    public void test002(){
        String[] strs = new String[5];
        strs[0] = "a";
        strs[1] = "a";
        strs[2] = "a";
        strs[3] = "d";
        strs[4] = "e";
        List<String> members = Arrays.asList(strs);
        int totolNumber = (int) members.stream()
                .filter(compareLevelName ->{
                    System.out.println(compareLevelName);
                    return StringUtils.equals("a", compareLevelName);
                } ).count();
        System.out.println(totolNumber);
    }

    @Test
    public void test003(){
        AtomicReference<Integer> total = new AtomicReference<>(0);
        List<Integer> integers = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1);
        System.out.println(integers.stream().count());
        integers.parallelStream().forEach(
                e->{
                    total.updateAndGet(v -> v + e);
                }
        );
        System.out.println(total);
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
    }

}
