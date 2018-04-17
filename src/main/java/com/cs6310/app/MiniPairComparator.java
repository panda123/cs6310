package com.cs6310.app;

import java.util.Comparator;

public class MiniPairComparator implements Comparator<MiniPair> {
    public int compare(MiniPair x, MiniPair y) { return x.getValue() - y.getValue(); }
}
