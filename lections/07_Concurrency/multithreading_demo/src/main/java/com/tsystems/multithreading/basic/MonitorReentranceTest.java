package com.tsystems.multithreading.basic;

import org.junit.Test;

/**
 * @author aesipov
 */
public class MonitorReentranceTest {
    Object lock = new Object();

    @Test(timeout = 100)
    public void test1() {
        synchronized (lock) {
            synchronized (lock) {
                System.out.println("Hello World!");
            }
        }
    }

    @Test(timeout = 100)
    public void test2() {
        recursiveCountDownPrint(10);
    }

    private void recursiveCountDownPrint(int value) {
        synchronized (lock) {
            if (value <= 0) {
                return;
            } else {
                System.out.println(value);
                recursiveCountDownPrint(--value);
            }
        }
    }
}
