package com.example.gaurav.mytimetable.DayModel;

/**
 * Created by gaurav on 8/14/2017.
 */

public class MondayModel {
    private String work;
    private String startTime;
    private String endTime;

    public MondayModel(String work, String startTime, String endTime) {
        this.work = work;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
