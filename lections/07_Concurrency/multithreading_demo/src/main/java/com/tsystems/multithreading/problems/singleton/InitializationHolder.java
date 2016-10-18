package com.tsystems.multithreading.problems.singleton;

/**
 * @author eas
 */
public class InitializationHolder {

    private InitializationHolder() {
        System.out.println("create");
    }

    private static class InstanceHolder {
        private static final InitializationHolder instance = new InitializationHolder();
    }

    public static InitializationHolder getInstance() {
        return InstanceHolder.instance;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
        Thread.sleep(5000);
        getInstance();
    }
}
