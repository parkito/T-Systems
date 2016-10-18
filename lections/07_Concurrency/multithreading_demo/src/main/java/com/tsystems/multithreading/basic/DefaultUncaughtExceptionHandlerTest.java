package com.tsystems.multithreading.basic;

import org.junit.Test;

/**
 * @author eas
 */
public class DefaultUncaughtExceptionHandlerTest {

    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println(availableProcessors);
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Opps!");
            }
        });

        throw new RuntimeException("123");
    }
}
