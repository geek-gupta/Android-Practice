package com.example.gaurav.postservicesonweb.model;

/**
 * Created by gaurav on 7/4/2017.
 */

public class CourseModel {
    String name;
    int id;
    String job;
    String teacher;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
