package com.tsystems.multithreading.problems.singleton;

/**
 * Created by eas on 23.02.2016.
 */
public class LazyInitSynchronized {
    private static LazyInitSynchronized instance;

    private LazyInitSynchronized() {
    }

    public static synchronized LazyInitSynchronized getInstance() {
        if (instance == null) {
            instance = new LazyInitSynchronized();
        }
        return instance;
    }
}
