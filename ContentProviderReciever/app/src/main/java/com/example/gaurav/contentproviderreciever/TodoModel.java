package com.example.gaurav.contentproviderreciever;

/**
 * Created by gaurav on 7/6/2017.
 */

public class TodoModel {
    int id;
    String task;
    //boolean isDone;
   static int runningtask=0;

    public TodoModel(int id, String task) {
        this.id = id;
        this.task = task;
        //this.isDone = isDone;
    }

   

    public TodoModel(String task){
        this.id = runningtask++;
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
