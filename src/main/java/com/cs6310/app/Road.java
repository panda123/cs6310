package com.cs6310.app;

import java.util.HashMap;

public class Road {

    private Integer ID;
    private Double distance;
    private Double speed;

    public Road(Integer ID, Double distance, Double speed) {
        this.ID = ID;
        this.distance = distance;
        this.speed = speed;
    }

    public Double calculateTime() {
        if (this.speed == 0) {
            this.speed = 0.01;
        }
        return this.distance / this.speed;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }
}
