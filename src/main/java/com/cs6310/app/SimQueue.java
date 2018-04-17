package com.cs6310.app;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SimQueue {
    private static PriorityQueue<SimEvent> eventQueue;
    private Comparator<SimEvent> simComparator;
    final static Integer passengerFrequency = 3;

    public SimQueue() {
        simComparator = new SimEventComparator();
        eventQueue = new PriorityQueue<SimEvent>(100, simComparator);
    }

    public void triggerNextEvent(TransportationSystem vehicleModel) {
        if (eventQueue.size() > 0) {
            SimEvent activeEvent = eventQueue.poll();
            activeEvent.displayEvent();
            switch (activeEvent.getType()) {
                case "move_bus":
                    // identify the vehicle that will move
                    Vehicle activeVehicle = vehicleModel.getVehicle(activeEvent.getID());
                    System.out.println(" the vehicle being observed is: " + Integer.toString(activeVehicle.getID()));

                    // identify the current stop
                    Route activeRoute = vehicleModel.getRoute(activeVehicle.getRoute());
                    System.out.println(" the vehicle is driving on route: " + Integer.toString(activeRoute.getID()));

                    int activeLocation = activeVehicle.getCurrentLocation();
                    int activeStopID = activeRoute.getStopID(activeLocation);
                    Stop activeStop = vehicleModel.getStop(activeStopID);
                    System.out.println(" the vehicle is currently at stop: " + Integer.toString(activeStop.getID()) + " - " + activeStop.getName());


                    // drop off and pickup new passengers at current stop
                    int currentPassengers = activeVehicle.getPassengers();
                    //activeStop.exchangeRiders(activeVehicle);
                    int postPassengers = activeVehicle.getPassengers();
                    System.out.println(" passengers pre-stop: " + Integer.toString(currentPassengers) + " post-stop: " + Integer.toString(postPassengers));

                    // determine next stop
                    Stop nextStop = vehicleModel.getStop(activeStop.getID());
                    //System.out.println(" the vehicle is heading to stop: " + Integer.toString(nextStopID) + " - " + nextStop.getName() + "\n");

                    Path nextPath = activeRoute.getNextPath(activeStop.getID());
                    //int travelTime = 1 + nextPath.calculateTime();
                    //activeVehicle.setLocation(nextLocation);

                    // generate next event for this bus
                    //eventQueue.add(new SimEvent(activeEvent.getRank() + travelTime, "move_vehicle", activeEvent.getID()));
                    break;
                default:
                    System.out.println(" event not recognized");
                    break;
            }
        } else {
            System.out.println(" event queue empty");
        }
    }

    public void addNewEvent(Integer eventRank, String eventType, Integer eventID) {
        eventQueue.add(new SimEvent(eventRank, eventType, eventID));
    }
}

