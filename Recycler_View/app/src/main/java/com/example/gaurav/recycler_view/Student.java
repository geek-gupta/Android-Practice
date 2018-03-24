package com.example.gaurav.recycler_view;

/**
 * Created by gaurav on 6/13/2017.
 */

public class Student {
    private int age;
    private String name;
    private String course;

    Student(int age,String name,String course){
        this.age=age;
        this.course=course;
        this.name=name;
    }
    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
    public String getCourse(){
        return course;
    }
}
