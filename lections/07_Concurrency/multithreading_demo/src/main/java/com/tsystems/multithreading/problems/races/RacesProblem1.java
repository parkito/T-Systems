package com.tsystems.multithreading.problems.races;

import org.junit.Assert;

/**
 * @author aesipov
 */
public class RacesProblem1 {

    private static int v;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                v = 10;
                Thread.yield();
                Assert.assertTrue(v == 10);
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                v = 20;
                Thread.yield();
                Assert.assertTrue(v == 20);
            }
        };
        t1.start();
        t2.start();
//        t1.join();
//        t2.join();
    }
}
