package com.tsystems.multithreading.problems;

import java.util.Random;

/**
 * @author Pavel Dyadych
 */
public class ThreadUtils {

    public static void forcePreemptThread() {
        try {
            // wait to simulate thread preemption ...
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException ignored) {
        }
    }
}
