package com.cs6310.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public abstract class Vehicle {
    private Integer ID;
    private String type;
    private Integer route;
    private Integer currentLocation;
    private Integer nextLocation;
    private Integer prevLocation;
    private List<RiderGroup> riderGroups;
    private Integer capacity;
    private Integer speed;
    private Integer passengers;

    Vehicle(String inputType, int uniqueValue, int inputRoute, int inputLocation, int inputPassengers,
            int inputCapacity, int inputSpeed) {
        this.ID = uniqueValue;
        this.type = inputType;
        this.route = inputRoute;
        this.currentLocation = inputLocation;
        this.nextLocation = inputLocation;
        this.prevLocation = inputLocation;
        this.riderGroups = new ArrayList<RiderGroup>(); // What is initial rider groups with passengers input?
        this.capacity = inputCapacity;
        this.speed = inputSpeed;
        this.passengers = inputPassengers;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getRoute() {
        return route;
    }

    public void setRoute(Integer route) {
        this.route = route;
    }

    public Integer getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Integer currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Integer getNextLocation() {
        return nextLocation;
    }

    public void setNextLocation(Integer nextLocation) {
        this.nextLocation = nextLocation;
    }

    public Integer getPrevLocation() {
        return prevLocation;
    }

    public void setPrevLocation(Integer prevLocation) {
        this.prevLocation = prevLocation;
    }

    public List<RiderGroup> getRiderGroups() {
        return riderGroups;
    }

    public void setRiderGroups(ArrayList<RiderGroup> riderGroups) {
        this.riderGroups = riderGroups;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getPassengers() {
        return passengers;
    }

    public void setPassengers(Integer passengers) {
        this.passengers = passengers;
    }

    public void displayEvent() {
        System.out.println(" vehicle: " + Integer.toString(this.ID));
    }

    public void displayInternalStatus() {
        System.out.print("> vehicle (" + type + ") - ID: " + Integer.toString(ID) + " route: " + Integer.toString(route));
        System.out.print(" location from: " + Integer.toString(prevLocation) + " to: " + Integer.toString(nextLocation));
        System.out.print(" passengers: " + Integer.toString(passengers) + " capacity: " + Integer.toString(capacity));
        System.out.println(" speed: " + Integer.toString(speed));
    }

    public void takeTurn() {
        System.out.println("drop off passengers - pickup passengers to capacity - move to next stop");
    }

    // TODO
    public double calculateTime() { return 0; }

    public Integer removeRiderGroup(int groupID) {
        for (int i = 0; i < riderGroups.size(); i++) {
            if (riderGroups.get(i).getID() == groupID) {
                riderGroups.remove(i);
                return i;
            }
        }

        return -1;
    }

    public void addRiderGroup(RiderGroup riders) {
        int remainingSeats = capacity - passengers;
        if (riders.getCount() <= remainingSeats) {
            riderGroups.add(riders);
            passengers += riders.getCount();
        } else { // Vehicle would be over max capacity
            riderGroups.add(new RiderGroup(riders.getID(), remainingSeats, riders.getStartStop(), riders.getEndStop()));
            passengers = capacity;
        }
    }


}
