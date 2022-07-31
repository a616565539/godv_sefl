package com.godv.lgd.juc;

import com.godv.lgd.dao.Person;
import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

public class SynchronizedTest {

    private static AtomicInteger atomicInteger =new AtomicInteger(0);

    public static void main(String[] args) {
        atomicInteger.incrementAndGet();
    }

    @Test
    public void removeTest(){
        Person person1 = new Person("1",1);
        Person person2 = new Person("2",2);
        Person person3 = new Person("3",3);

        ConcurrentSkipListSet<Person> personConcurrentSkipListSet = new ConcurrentSkipListSet<>();
        personConcurrentSkipListSet.add(new Person("1",1));
        boolean remove = personConcurrentSkipListSet.remove(person1);
        System.out.println(remove);

    }


    @Test
    public void mapTest(){

        HashMap<String, String> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("1","1");
        objectObjectHashMap.put("2","2");
        objectObjectHashMap.put("1","1");
        objectObjectHashMap.forEach((s1, s2) -> {
            System.out.println(s1);
            System.out.println(s2);
        });
        System.out.println(objectObjectHashMap);
    }
}
