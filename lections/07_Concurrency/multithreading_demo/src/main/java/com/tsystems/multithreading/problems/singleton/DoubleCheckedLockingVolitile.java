package com.tsystems.multithreading.problems.singleton;

/**
 * Created by eas on 23.02.2016.
 */
public class DoubleCheckedLockingVolitile {
    private static volatile DoubleCheckedLockingVolitile instance;

    private DoubleCheckedLockingVolitile() {
    }

    public static DoubleCheckedLockingVolitile getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingVolitile.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockingVolitile();
                }
            }
        }
        return instance;
    }
}
