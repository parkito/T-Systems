package com.tsystems.multithreading.problems.deadlock;

import com.tsystems.multithreading.problems.ThreadUtils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author aesipov
 */
public class DeadlockProblemReentrantLock {

    static class Point {
        private Lock lockX = new ReentrantLock();
        private Lock lockY = new ReentrantLock();

        private Integer x = 0;
        private Integer y = 0;

        public void setValue(int x, int y) {
            lockX.lock();
            ThreadUtils.forcePreemptThread();
            lockY.lock();

            this.x = x;
            this.y = y;

            lockY.unlock();
            lockX.unlock();
        }

        public void move(int deltaX, int deltaY) {
            lockY.lock();
            ThreadUtils.forcePreemptThread();
            lockX.lock();

            this.x += deltaX;
            this.y += deltaY;

            lockX.unlock();
            lockY.unlock();
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
    }


}
