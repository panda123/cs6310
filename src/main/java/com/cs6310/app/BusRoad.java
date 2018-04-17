package com.cs6310.app;

import java.util.HashMap;

public class BusRoad extends Road {

    private String criteria;

    public BusRoad(Integer ID, String criteria, Double distance) {
        super(ID, distance, 0.0);
        switch (criteria) {
            case "slowBusroad":
                this.setSpeed(25.0); // usually in school zone
                break;
            case "normalBusroad":
                this.setSpeed(45.0); // a normal speed
                break;
            case "highwayBusroad":
                this.setSpeed(65.0); // a highway speed
                break;
            case "randomTrafficBusroad":
                this.setSpeed(30 + Math.random() * 55 - 30); // random speed in a city
                break;
            case "heavyTrafficBusroad":
                this.setSpeed(0.01 + Math.random() * 30); // random speed when traffic is heavy
                break;
            default:
                this.setSpeed(45.0);
                break;
        }

        this.criteria = criteria;
    }

    @Override
    public Double calculateTime() {
        // bring some randomness in speed calculation
        Double speed;
        if (this.criteria.equals("slowBusroad")) {
            // for slowBusroads such as school zone roads, their speed limit is very strict.
            // the bus speed should be slower than 25 mph
            speed = this.getSpeed() - this.getSpeed() * 0.1 * Math.random();  // from 25*09 to 25 mph
        } else {
            // for other roads, the speed limit is not very strict. Their could be a 5 mile fluctuation
            speed = this.getSpeed() + (0.5 - Math.random()) * 10;
            if (speed <= 0) {
                speed = 0.1;
            }
        }

        return this.getDistance() / speed;
    }

}

