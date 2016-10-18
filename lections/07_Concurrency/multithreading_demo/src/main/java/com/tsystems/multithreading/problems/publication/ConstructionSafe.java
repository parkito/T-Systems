package com.tsystems.multithreading.problems.publication;

import java.util.HashSet;
import java.util.Set;

public class ConstructionSafe {

    private Object me;
    private Set set = new HashSet();
    private Thread thread;

    public ConstructionSafe() {
        // Безопасно, потому что "me" невидимо из любого другого потока
        me = this;

        // Безопасно, потому что "set" невидимо из любого другого потока
        set.add(this);

        // Безопасно, потому что MyThread не запустится, пока не будет завершена работа конструктора
        // и конструктор не опубликует указатель
        thread = new MyThread(this);
    }

    public void start() {
        thread.start();
    }

    private class MyThread extends Thread {
        private Object theObject;

        public MyThread(Object o) {
            this.theObject = o;
        }
    }
}