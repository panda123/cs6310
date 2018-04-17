package com.cs6310.app;

public class VehicleFactory {

    public static Vehicle createVehicle(String type, int uniqueValue, int inputRoute, int inputLocation,
                                        int inputPassengers, int inputCapacity, int inputSpeed) {
        if (type.equalsIgnoreCase("Bus")) {
            return new Bus(uniqueValue, inputRoute, inputLocation, inputPassengers, inputCapacity, inputSpeed);
        } else if (type.equalsIgnoreCase("Rails")) {
            return new Rails(uniqueValue, inputRoute, inputLocation, inputPassengers, inputCapacity, inputSpeed);
        }

        return null;
    }
}
