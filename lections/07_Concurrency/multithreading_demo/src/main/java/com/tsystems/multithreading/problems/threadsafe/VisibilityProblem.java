package com.tsystems.multithreading.problems.threadsafe;

public class VisibilityProblem {
    static boolean ready = false;
    static int number = 0;

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