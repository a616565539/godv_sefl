package com.godv.lgd.dao;


import org.springframework.stereotype.Component;

@Component

public class Person {

    private String name;

    private double score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Person(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
