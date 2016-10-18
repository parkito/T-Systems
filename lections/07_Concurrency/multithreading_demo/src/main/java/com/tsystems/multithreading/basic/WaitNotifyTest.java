package com.tsystems.multithreading.basic;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author eas
 */
public class WaitNotifyTest {

    @Test(expected = IllegalMonitorStateException.class)
    public void test1() {
        new Object().notify();
    }

    @Test(expected = IllegalMonitorStateException.class)
    public void test2() {
        Object lock1 = new Object();
        Object lock2 = new Object();
        synchronized (lock2) {
            lock1.notify();
        }
    }

    @Test()
    public void test3() {
        Object lock = new Object();
        synchronized (lock) {
            lock.notify();
        }
    }

    @Test()
    public void notifyNaiveTest() throws InterruptedException {
        final Object lock = new Object();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait(); //spurious wakeups are possible
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread t1 finished");
                }
            }
        });
        t.start();
        Thread.sleep(100);

        synchronized (lock) {
            lock.notify();
            System.out.println("main thread finished");
        }

        Thread.sleep(100);
        Assert.assertTrue(t.isAlive() == false);
    }

    public class Condition {
        boolean done;
    }

    @Test()
    public void notifyTest() throws InterruptedException {
        final Condition condition = new Condition();
        final Object lock = new Object();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        while (!condition.done) {
                            lock.wait(); //spurious wakeups are possible
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread t1 finished");
                }
            }
        });
        t.start();
        Thread.sleep(100);

        synchronized (lock) {
            condition.done = true;
            lock.notify();
            System.out.println("main thread finished");
        }

        Thread.sleep(100);
        Assert.assertTrue(t.isAlive() == false);
    }


    @Test()
     public void notifyAllTest() throws InterruptedException {
        final Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("t1 acquired monitor");
                    try {
                        System.out.println("t1 wait condition");
                        lock.wait();
                        System.out.println("t1 acquired monitor again");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("t2 acquired monitor");
                    try {
                        System.out.println("t2 wait condition");
                        lock.wait();
                        System.out.println("t2 acquired monitor again");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();
        Thread.sleep(100);

        synchronized (lock) {
            System.out.println("t3 acquired monitor");
            lock.notifyAll();
            System.out.println("t3 notified all");
        }
    }

}
