package com.example.gaurav.revise_listview;

/**
 * Created by gaurav on 6/13/2017.
 */

public class Student {


    int age;
    String name;
    String course;

    Student(int age,String name,String course){
        this.age=age;
        this.course=course;
        this.name=name;
    }

    public  int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
    public  String getName(){
            return name;
    }
    public void setName(String name){
            this.name=name;

    }
    public  String getCourse(){
            return course;
    }
    public void setCourse(){
            this.course=course;
    }
}
