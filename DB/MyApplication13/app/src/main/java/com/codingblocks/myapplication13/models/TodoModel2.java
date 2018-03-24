package com.codingblocks.myapplication13.models;

/**
 * Created by Nipun on 7/6/17.
 */

public class TodoModel2 {
    int id;
    String task;
    static int runningId = 1;

    public TodoModel2() {
    }

    public TodoModel2(int id, String task) {
        this.id = id;
        this.task = task;
    }

    public TodoModel2(String task) {
        this.id = runningId++;
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
