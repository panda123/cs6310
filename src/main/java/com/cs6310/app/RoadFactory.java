package com.cs6310.app;

import java.util.HashMap;


public class RoadFactory {
    public static Road createRoad(int id, String roadType, String criteria, Double distance){
        // roadType determines whether it is a busroad or railsroad.
        // criteria determines the road condition
        if(roadType.equals("busRoad")){
            return new BusRoad(id, criteria, distance);
        }
        else if(roadType.equals("railsRoad")){
            return new RailsRoad(id, distance);
        }

        return null;
    }
}
