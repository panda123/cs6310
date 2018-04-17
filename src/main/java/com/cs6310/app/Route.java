package com.cs6310.app;

import java.util.ArrayList;
import java.util.HashMap;

public class Route {
    private Integer ID;
    private Integer routeNumber;
    private String routeName;
    private ArrayList<Stop> stopList;
    private HashMap<Integer, Integer> stopsOnRoute; //stopID->index in stoplist, pathlist
    private ArrayList<Path> pathList;

    public Route() {
        this.ID = -1;
    }

    public Route(int uniqueValue) {
        this.ID = uniqueValue;
        this.routeNumber = -1;
        this.routeName = "";
        this.stopsOnRoute = new HashMap<Integer, Integer>();
        this.stopList = new ArrayList<Stop>();
        this.pathList = new ArrayList<Path>();
    }

    public Route(int uniqueValue, int inputNumber, String inputName) {
        this.ID = uniqueValue;
        this.routeNumber = inputNumber;
        this.routeName = inputName;
        this.stopsOnRoute = new HashMap<Integer, Integer>();
        this.stopList = new ArrayList<Stop>();
        this.pathList = new ArrayList<Path>();
    }

    public void setNumber(int inputNumber) { this.routeNumber = inputNumber; }

    public void setName(String inputName) { this.routeName = inputName; }

    public void addNewStop(Stop stop, Path path) {
        this.stopList.add(stop);
        this.pathList.add(path);
        this.stopsOnRoute.put(stop.getID(), stopList.size()-1);
    }

    public Integer getID() { return this.ID; }

    public Integer getNumber() { return this.routeNumber; }

    public String getName() { return this.routeName; }

    public void displayEvent() {
        System.out.println(" bus route: " + Integer.toString(this.ID));
    }

    public void takeTurn() {
        System.out.println("provide next stop on route along with the distance");
    }

    public Stop getNextStop(int curStop) {//returns stop object
        int nextStop = getNextStopIndex(curStop);
        return nextStop > -1 ? stopList.get(nextStop) : null;
    }

    public Path getNextPath(int curStop) {//returns path object starting from current stop to next stop
        int curStopIndex = stopsOnRoute.get(curStop);
        return curStopIndex > -1 ? pathList.get(curStopIndex) : null;
    }

    private int getNextStopIndex(int curStop) {
        int routeSize = this.stopList.size();
        if (routeSize > 0) {
            int curStopIndex = stopsOnRoute.get(curStop);
            int index = (curStopIndex + 1) % routeSize;
            return index;
        }
        return -1;
    }

    public Integer getStopID(int routeLocation) { return this.stopsOnRoute.get(routeLocation); }

    public Integer getLength() { return this.stopsOnRoute.size(); }

    public void displayInternalStatus() {
        System.out.print("> route - ID: " + Integer.toString(ID));
        System.out.print(" number: " + Integer.toString(routeNumber) + " name: " + routeName);
        System.out.print(" stops: [ ");
        for (int i = 0; i < stopsOnRoute.size(); i++) {
            System.out.print(Integer.toString(i) + ":" + Integer.toString(stopsOnRoute.get(i)) + " ");
        }
        System.out.println("]");
    }

    //Override the equals method to compare the object
    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Route me = (Route) object;
            if (this.ID == me.getID()) {
                result = true;
            }
        }
        return result;
    }

}

