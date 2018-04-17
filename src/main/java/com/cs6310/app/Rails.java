package com.cs6310.app;

public class Rails extends Vehicle {
    private String axis;
    private String branchRoutes;

    public Rails(int uniqueValue, int inputRoute, int inputLocation, int inputPassengers,
                 int inputCapacity, int inputSpeed) {
        super("Rails", uniqueValue, inputRoute, inputLocation, inputPassengers, inputCapacity, inputSpeed);
        this.axis = null;
        this.branchRoutes = null;
    }

    public Rails(int uniqueValue, int inputRoute, int inputLocation, int inputPassengers,
                 int inputCapacity, int inputSpeed, String inputAxis, String inputBranchRoutes) {
        super("Rails", uniqueValue, inputRoute, inputLocation, inputPassengers, inputCapacity, inputSpeed);
        this.axis = inputAxis;
        this.branchRoutes = inputBranchRoutes;
    }

    public String getAxis() {
        return axis;
    }

    public void setAxis(String axis) {
        this.axis = axis;
    }

    public String getBranchRoutes() {
        return branchRoutes;
    }

    public void setBranchRoutes(String branchRoutes) {
        this.branchRoutes = branchRoutes;
    }

    // TODO
    public void adjustBranch(int branch) {

    }
}
