package com.tsystems.multithreading.problems.threadsafe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author eas
 */
public class SequenceGeneratorAtomic {
    private AtomicInteger value = new AtomicInteger(0);

    public int getNext() {
        return value.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        int n = 1000;
        final int[] results = new int[n];
        final SequenceGeneratorAtomic sequence = new SequenceGeneratorAtomic();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            final int index = i;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    results[index] = sequence.getNext();
                }
            });
            threads.add(t);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        //print result
        for (int i = 0; i < n; i++) {
            System.out.print(results[i] + ", ");
            if (i % 30 == 0) {
                System.out.println();
            }
        }

        System.out.println();
        System.out.println("--------------");

        //print duplicated and missing numbers
        for (int i = 0; i < n; i++) {
            int occurrenceCount = 0;
            for (int j = 0; j < results.length; j++) {
                if (results[j] == i) {
                    occurrenceCount++;
                }
            }
            if (occurrenceCount == 0) {
                System.out.println(i + " - is missing");
            }
            if (occurrenceCount > 1) {
                System.out.println(i + " - occurs more than once");
            }
        }
    }
}
