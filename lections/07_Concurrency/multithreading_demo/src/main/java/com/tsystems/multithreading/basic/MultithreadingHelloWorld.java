package com.tsystems.multithreading.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eas
 */
public class MultithreadingHelloWorld {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread t = new HelloWorldThread();
//            Thread t = new Thread(new HelloWorldRunnable());
            t.setName("Thread-" + i);
            threads.add(t);
        }
        for (Thread t : threads) {
            t.setDaemon(true);
//            t.run();
            t.start();
        }
//        Thread.sleep(500);
    }

    static class HelloWorldThread extends Thread {
        @Override
        public void run() {
            threadActivity();
        }
    }

    static class HelloWorldRunnable implements Runnable {
        @Override
        public void run() {
            threadActivity();
        }
    }

    private static void threadActivity() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " - Hi!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " - Bye!");
    }
}
