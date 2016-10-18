package com.tsystems.multithreading.basic;

/**
 * @author eas
 */
public class WaitNotifyExample {

    private static volatile String message;
    private static volatile boolean sent = false;

    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(lock) {
                    while (!sent) {
                        try {
                            System.out.println("t1 waiting for message...");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("t1 receive message: " + message);
                }
            }
        });
        t1.start();
        Thread.sleep(2000);

        synchronized (lock) {
            message = "Hi!";
            sent = true;
            System.out.println("main send message");
            lock.notify();
        }
    }
}
