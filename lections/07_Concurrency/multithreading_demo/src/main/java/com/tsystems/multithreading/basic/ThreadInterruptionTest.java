package com.tsystems.multithreading.basic;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author eas
 */
public class ThreadInterruptionTest {

    @Test()
    public void isInterruptedTest() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("thread t: do some work");
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("thread t: interrupted");
                        Assert.assertTrue(Thread.currentThread().isInterrupted());
                        break;
                    }
                }
                System.out.println("thread t: finished");
            }
        });
        t.start();

        Thread.sleep(1);
        System.out.println("main thread: interrupt thread t");
        t.interrupt();

        Thread.sleep(100);
        Assert.assertFalse(t.isAlive());
    }

    @Test()
    public void interruptedTest() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("thread t: do some work");
                    if (Thread.interrupted()) {
                        System.out.println("thread t: interrupted");
                        Assert.assertFalse(Thread.currentThread().isInterrupted());
                        Assert.assertFalse(Thread.interrupted());
                        break;
                    }
                }
                System.out.println("thread t: finished");
            }
        });
        t.start();

        Thread.sleep(1);
        System.out.println("main thread: interrupt thread t");
        t.interrupt();

        Thread.sleep(100);
        Assert.assertFalse(t.isAlive());
    }

    @Test()
    public void interruptedExceptionTest() throws InterruptedException {
        final Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread t1: started");

                try {
                    System.out.println("thread t1: sleep 1 minute");
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    System.out.println("thread t1: was interrupted");
                }

                synchronized (lock) {
                    try {
                        System.out.println("thread t1: wait");
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println("thread t1: was interrupted");
                    }
                }

                Thread t2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });

                t2.start();

                try {
                    System.out.println("thread t1: join thread t2");
                    t2.join();
                } catch (InterruptedException e) {
                    System.out.println("thread t1: was interrupted");
                }

            }
        });
        t1.start();

        Thread.sleep(100);
        System.out.println("main thread: interrupt thread t1 which is sleeping");
        t1.interrupt();

        Thread.sleep(100);
        System.out.println("main thread: interrupt thread t1 which is waiting for condition");
        t1.interrupt();

        Thread.sleep(100);
        System.out.println("main thread: interrupt thread t1 which is waiting for finishing of thread t2 (join)");
        t1.interrupt();

        Thread.sleep(100);
        Assert.assertFalse(t1.isAlive());
    }
}
