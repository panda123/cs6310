package com.cs6310.app;
import java.util.Comparator;

public class SimEventComparator implements Comparator<SimEvent> {
    public int compare(SimEvent x, SimEvent y) {
        if (y == null) {
            return -1;
        } else if (x == null) {
            return 1;
        } else {
            return x.getRank() - y.getRank();
        }
    }

}
