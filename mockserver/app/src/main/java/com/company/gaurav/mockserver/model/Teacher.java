package com.company.gaurav.mockserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by gaurav on 2/12/17.
 */

public  final class Teacher {


    private Long id;


    private String name;


    private Integer age;

    public Teacher(Long mID, Integer mAge, String mName) {
        this.id = mID;

        this.name =
                mName;
        this.age = mAge;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Long getID() {
        return id;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "mID=" + id +
                ", mName='" + name + '\'' +
                ", mAge=" + age +
                '}';
    }
}