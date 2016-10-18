package com.tsystems.multithreading.problems.threadsafe;

public class VisibilityProblemVolatile {
    /**
     *  old model: can run infinitely, print 0 or 1
     *  new model: can run infinitely, print 0 or 1
     */
    static boolean ready = false;
    static int number = 0;

    /**
     *  old model: will finish, print 1
     *  new model: will finish, print 1
     */
//    static volatile boolean ready = false;
//    static volatile int number = 0;

    /**
     *  old model: will finish, print 0 or 1
     *  new model: will finish, print 1
     */
//    static volatile boolean ready = false;
//    static int number = 0;

    /**
     *  old model: can run infinitely, print 0 or 1
     *  new model: can run infinitely, print 0 or 1
     */
//    static boolean ready = false;
//    static volatile int number = 0;

    static class WriterThread extends Thread {
        public void run() {
            number = 1;
            ready = true;
        }
    }
    static class ReaderThread extends Thread {
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }
    public static void main(String[] args) {
        new ReaderThread().start();
        new WriterThread().start();
    }
}