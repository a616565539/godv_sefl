package com.godv.lgd.test;

import com.godv.lgd.dao.Person;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

public class GodVTest {


    public static void dgTest(int i){
        i++;
        if(i>10){
            return;
        }
        dgTest(i);
        System.out.println("6666");
    }

    public static void intTest(int i) {
        System.out.println(i++);
        System.out.println(++i);
    }

    public static void main(String[] args) {
        int i =1;
        dgTest(0);
        intTest(++i);
    }

    @Test
    public void test1(){

        String s = new BigDecimal("2.22222").divide(new BigDecimal(2)).toString();
        System.out.println(s);
    }

    @Test
    public void security(){
        Person person = new Person();
        person.setName("22");
        Person person1 = null;

        ArrayList<Person> objects = new ArrayList<>();
        Optional.ofNullable(person).ifPresent(o->{
            objects.add(o);
       });
        System.out.println(objects);

    }

    @Test
    public void security11() {
        String dayAgo = "自然会月".replace("天", "");
        System.out.println(dayAgo);
    }

}
