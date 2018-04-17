package com.cs6310.app;

import java.util.ArrayList;
import java.util.HashMap;

public class Path {
    private Integer startStopID;
    private ArrayList<Road> roads;
    private Integer endStopID;

    public Path() {
        this.startStopID = -1;
    }

    public Path(int startStopID, int endStopID) {
        this.startStopID = startStopID;
        this.endStopID = endStopID;
        this.roads = new ArrayList<Road>();
    }

    public double calculateTime() {
        double time = 0.0;
        for (Road road : this.roads) {
            time += road.calculateTime();
        }
        return time;
    }
}
