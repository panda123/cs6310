package com.cs6310.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.HashMap;

public class Stop {
    private Integer ID;
    private String stopName;
    private Double xCoord;
    private Double yCoord;
    private List<RiderGroup> riderGroups;

    public Stop() {
        this.ID = -1;
    }

    public Stop(int uniqueValue, String inputName, int inputRiders, double inputXCoord, double inputYCoord) {
        this.ID = uniqueValue;
        this.stopName = inputName;
        this.xCoord = inputXCoord;
        this.yCoord = inputYCoord;
        this.riderGroups = new ArrayList<RiderGroup>();
    }

    public void setName(String inputName) { this.stopName = inputName; }

    public void addRiders(RiderGroup riderGroup) { this.riderGroups.add(riderGroup); }

    public void setXCoord(double inputXCoord) { this.xCoord = inputXCoord; }

    public void setYCoord(double inputYCoord) { this.yCoord = inputYCoord; }

    public Integer getID() { return this.ID; }

    public String getName() { return this.stopName; }

    public Double getXCoord() { return this.xCoord; }

    public Double getYCoord() { return this.yCoord; }

    public void displayEvent() {
        System.out.println(" bus stop: " + Integer.toString(this.ID));
    }

    public void takeTurn() {
        System.out.println("get new people - exchange with bus when it passes by");
    }

    //TBD
    public Integer exchangeRiders() {
        return null;
    }

    public void displayInternalStatus() {
        System.out.print("> stop - ID: " + Integer.toString(ID));
        //System.out.print(" name: " + stopName + " waiting: " + Integer.toString(waiting));
        System.out.println(" xCoord: " + Double.toString(xCoord) + " yCoord: " + Double.toString(yCoord));
    }

    public void addArrivalInfo(int timeSlot, int minOn, int avgOn, int maxOn, int minOff, int avgOff, int maxOff) {
        //rateCatchingBus.put(timeSlot, new int[]{minOn, avgOn, maxOn});
        //rateLeavingBus.put(timeSlot, new int[]{minOff, avgOff, maxOff});
    }

    //Override the equals method to compare the object
    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Stop me = (Stop) object;
            if (this.ID == me.getID()) {
                result = true;
            }
        }
        return result;
    }

}

