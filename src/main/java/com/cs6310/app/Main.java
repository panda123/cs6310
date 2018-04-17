package com.cs6310.app;

/**
 * Created by haoqinggeng on 4/16/18.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Mass Transit Simulation System Starting...");

        SimDriver commandInterpreter = new SimDriver();
        commandInterpreter.runInterpreter();
    }
}
