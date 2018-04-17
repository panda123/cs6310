package com.cs6310.app;

public class Bus extends Vehicle {
    private Integer speedLimit;

    public Bus(int uniqueValue, int inputRoute, int inputLocation, int inputPassengers, int inputCapacity,
               int inputSpeed) {
        super("Bus", uniqueValue, inputRoute, inputLocation, inputPassengers, inputCapacity, inputSpeed);
        this.speedLimit = -1;
    }

    public Bus(int uniqueValue, int inputRoute, int inputLocation, int inputPassengers, int inputCapacity,
               int inputSpeed, int inputSpeedLimit) {
        super("Bus", uniqueValue, inputRoute, inputLocation, inputPassengers, inputCapacity, inputSpeed);
        this.speedLimit = inputSpeedLimit;
    }

    public Integer getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(Integer speedLimit) {
        this.speedLimit = speedLimit;
    }
}