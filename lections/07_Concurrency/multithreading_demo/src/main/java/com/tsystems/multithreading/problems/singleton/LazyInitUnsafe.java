package com.tsystems.multithreading.problems.singleton;

/**
 * Created by eas on 23.02.2016.
 */
public class LazyInitUnsafe {
    private static LazyInitUnsafe instance;

    private LazyInitUnsafe() {
    }

    public static LazyInitUnsafe getInstance() {
        if (instance == null) {
            instance = new LazyInitUnsafe();
        }
        return instance;
    }
}
