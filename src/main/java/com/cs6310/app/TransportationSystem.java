package com.cs6310.app;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class TransportationSystem {
    private HashMap<Integer, Stop> stops;
    private HashMap<Integer, Route> routes;
    private HashMap<Integer, Vehicle> vehicles;

    public TransportationSystem() {
        stops = new HashMap<Integer, Stop>();
        routes = new HashMap<Integer, Route>();
        vehicles = new HashMap<Integer, Vehicle>();
    }

    public Stop getStop(int stopID) {
        if (stops.containsKey(stopID)) {
            return stops.get(stopID);
        }
        return null;
    }

    public Route getRoute(int routeID) {
        if (routes.containsKey(routeID)) {
            return routes.get(routeID);
        }
        return null;
    }

    public Vehicle getVehicle(int vehicleID) {
        if (vehicles.containsKey(vehicleID)) {
            return vehicles.get(vehicleID);
        }
        return null;
    }

    public int makeStop(int uniqueID, String inputName, int inputRiders, double inputXCoord, double inputYCoord) {
        // int uniqueID = stops.size();

        stops.put(uniqueID, new Stop(uniqueID, inputName, inputRiders, inputXCoord, inputYCoord));
        return uniqueID;
    }

    public int makeRoute(int uniqueID, int inputNumber, String inputName) {
        // int uniqueID = routes.size();
        routes.put(uniqueID, new Route(uniqueID, inputNumber, inputName));
        return uniqueID;
    }

    public int makeVehicle(String type, int uniqueID, int inputRoute, int inputLocation, int inputPassengers,
                           int inputCapacity, int inputSpeed) {
        vehicles.put(uniqueID, VehicleFactory.createVehicle(type, uniqueID, inputRoute, inputLocation, inputPassengers,
                inputCapacity, inputSpeed));
        return uniqueID;
    }

    // TBD
    public void appendRoadToPath(int roadID, int PathID) {
    };

    //TBD
    public void appendStopToRoute(int routeID, int nextStopID) {
        //routes.get(routeID).addNewStop(nextStopID);
    }

    public HashMap<Integer, Stop> getStops() {
        return stops;
    }

    public HashMap<Integer, Route> getRoutes() {
        return routes;
    }

    public HashMap<Integer, Vehicle> getVehicles() {
        return vehicles;
    }

    // TBD
    public void displayModel() {
        ArrayList<MiniPair> busNodes, stopNodes;
        MiniPairComparator compareEngine = new MiniPairComparator();

        int[] colorScale = new int[] { 9, 29, 69, 89, 101 };
        String[] colorName = new String[] { "#000077", "#0000FF", "#000000", "#770000", "#FF0000" };
        Integer colorSelector, colorCount, colorTotal;

        try {
            // create new file access path
            String path = "./mts_digraph.dot";
            File file = new File(path);

            // create the file if it doesn't exist
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("digraph G\n");
            bw.write("{\n");

            busNodes = new ArrayList<MiniPair>();
            for (Vehicle b : vehicles.values()) {
                busNodes.add(new MiniPair(b.getID(), b.getPassengers()));
            }
            Collections.sort(busNodes, compareEngine);

            colorSelector = 0;
            colorCount = 0;
            colorTotal = busNodes.size();
            for (MiniPair c : busNodes) {
                if (((int) (colorCount++ * 100.0 / colorTotal)) > colorScale[colorSelector]) {
                    colorSelector++;
                }
                bw.write("  bus" + c.getID() + " [ label=\"bus#" + c.getID() + " | " + c.getValue()
                        + " riding\", color=\"" + colorName[colorSelector] + "\"];\n");
            }
            bw.newLine();

            stopNodes = new ArrayList<MiniPair>();
            for (Stop s : stops.values()) {
                //stopNodes.add(new MiniPair(s.getID(), s.getWaiting()));
            }
            Collections.sort(stopNodes, compareEngine);

            colorSelector = 0;
            colorCount = 0;
            colorTotal = stopNodes.size();
            for (MiniPair t : stopNodes) {
                if (((int) (colorCount++ * 100.0 / colorTotal)) > colorScale[colorSelector]) {
                    colorSelector++;
                }
                bw.write("  stop" + t.getID() + " [ label=\"stop#" + t.getID() + " | " + t.getValue()
                        + " waiting\", color=\"" + colorName[colorSelector] + "\"];\n");
            }
            bw.newLine();

            for (Vehicle m : vehicles.values()) {
                Integer prevStop = routes.get(m.getRoute()).getStopID(m.getPrevLocation());
                Integer nextStop = routes.get(m.getRoute()).getStopID(m.getCurrentLocation());
                bw.write("  stop" + Integer.toString(prevStop) + " -> bus" + Integer.toString(m.getID())
                        + " [ label=\" dep\" ];\n");
                bw.write("  bus" + Integer.toString(m.getID()) + " -> stop" + Integer.toString(nextStop)
                        + " [ label=\" arr\" ];\n");
            }

            bw.write("}\n");
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

