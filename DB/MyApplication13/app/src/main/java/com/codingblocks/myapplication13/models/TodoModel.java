package com.codingblocks.myapplication13.models;

/**
 * Created by Nipun on 7/6/17.
 */

public class TodoModel {
    int id;
    String task;

    public TodoModel() {
    }

    public TodoModel(int id, String task) {
        this.id = id;
        this.task = task;
    }

    public TodoModel(String task) {
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
