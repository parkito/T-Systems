package com.tsystems.multithreading.problems.deadlock;

import com.tsystems.multithreading.problems.ThreadUtils;

/**
 * @author aesipov
 */
public class DeadlockProblem {

    static class Point {
        private Object lockX = new Object();
        private Object lockY = new Object();

        private Integer x = 0;
        private Integer y = 0;

        public void setValue(int x, int y) {
            synchronized (lockX) {
                System.out.println("setValue");
                ThreadUtils.forcePreemptThread();
                synchronized (lockY) {
                    this.x = x;
                    this.y = y;
                }
            }
        }

        public void move(int deltaX, int deltaY) {
            synchronized (lockY) {
                System.out.println("move");
                ThreadUtils.forcePreemptThread();
                synchronized (lockX) {
                    this.x += deltaX;
                    this.y += deltaY;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Point point = new Point();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                point.setValue(10, 20);
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                point.move(10, 20);
            }
        };
        t1.start();
        t2.start();
//        t1.join();
//        t2.join();
    }


}
