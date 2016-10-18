package com.tsystems.multithreading.problems.threadsafe;

class FinalFieldExample1 {
    final int x;
    int y;
    static FinalFieldExample1 instance;

    public FinalFieldExample1() {
        x = 3;
        y = 4;
    }

    static void writer() {
        instance = new FinalFieldExample1();
    }

    static void reader() {
        if (instance != null) {
            int i = instance.x; // i == 3
            int j = instance.y; // have no guarantees that i == 4
        }
    }
}