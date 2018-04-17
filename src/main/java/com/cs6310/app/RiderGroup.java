package com.cs6310.app;

import java.util.HashMap;

public class RiderGroup {
    private Integer ID;
    private Integer count;
    private Integer startStop;
    private Integer endStop;

    public RiderGroup(int ID, int count, int startStop, int endStop) {
        this.ID = ID;
        this.count = count;
        this.startStop = startStop;
        this.endStop = endStop;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getStartStop() {
        return startStop;
    }

    public void setStartStop(Integer startStop) {
        this.startStop = startStop;
    }

    public Integer getEndStop() {
        return endStop;
    }

    public void setEndStop(Integer endStop) {
        this.endStop = endStop;
    }
}
