package com.tsystems.multithreading.basic;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author eas
 */
public class ThreadStateTest {
    @Test
    public void runnableStateTest() {
        Assert.assertEquals(Thread.State.RUNNABLE, Thread.currentThread().getState());
    }

    @Test
    public void allStatesTest() throws InterruptedException {
        final Object lock = new Object();
        Thread t = new Thread() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    try {
                        lock.wait(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Assert.assertEquals(Thread.State.NEW, t.getState());

        t.start();
        Assert.assertEquals(Thread.State.RUNNABLE, t.getState());

        synchronized (lock) {
            Thread.sleep(500);
            Assert.assertEquals(Thread.State.BLOCKED, t.getState());
        }

        Thread.sleep(500);
        Assert.assertEquals(Thread.State.WAITING, t.getState());

        synchronized (lock) {
            lock.notify();
        }

        Thread.sleep(100);
        Assert.assertEquals(Thread.State.TIMED_WAITING, t.getState());

        synchronized (lock) {
            lock.notify();
        }

        t.join();
        Assert.assertEquals(Thread.State.TERMINATED, t.getState());
    }

    @Test
    public void joinStatusTest() throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                Thread t2 = new Thread() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };

                t2.start();

                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();

        Thread.sleep(500);
        Assert.assertEquals(Thread.State.WAITING, t1.getState());

    }
}
