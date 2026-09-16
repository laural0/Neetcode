package DesignHashSet;

import java.util.ArrayList;
import java.util.List;

public class MyHashSet {
    private final boolean[] items;

    public MyHashSet() {
        items = new boolean[1000001];
    }

    public void add(int key) {
        items[key] = true;
    }

    public void remove(int key) {
        items[key] = false;
    }

    public boolean contains(int key) {
        return items[key];
    }
}
