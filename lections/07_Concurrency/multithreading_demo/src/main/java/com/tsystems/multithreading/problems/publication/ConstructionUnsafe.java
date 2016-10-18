package com.tsystems.multithreading.problems.publication;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ConstructionUnsafe {
    public static ConstructionUnsafe anInstance;
    public static Set set = new HashSet();
    private Set mySet = new HashSet();

    public ConstructionUnsafe() {
        // Небезопасно, потому что anInstance виден всем
        anInstance = this;

        // Небезопасно, потому что SomeOtherClass.anInstance виден всем
        SomeOtherClass.anInstance = this;

        // Небезопасно, потому что SomeOtherClass может сохранить указатель "this"
        // так, что он может быть виден другому потоку
        SomeOtherClass.registerObject(this);

        // Небезопасно, потому что set имеет глобальную видимость
        set.add(this);

        // Небезопасно, потому что мы публикуем указатель на mySet
        mySet.add(this);
        SomeOtherClass.someMethod(mySet);

        // Небезопасно, потому что объект "this" будет виден из нового
        // потока до того, как конструктор завершит работу
        Thread thread = new MyThread(this);
        thread.start();
    }

    public ConstructionUnsafe(Collection c) {
        // Небезопасно, потому что "c" может быть видимо из других потоков
        c.add(this);
    }

    public static class SomeOtherClass {
        public static Object anInstance;
        public static Object unsafe;
        public static Object mySet;

        public static void registerObject(ConstructionUnsafe unsafe) {
            SomeOtherClass.unsafe = unsafe;
        }

        public static void someMethod(Set mySet) {
            SomeOtherClass.mySet = mySet;
        }
    }

    private class MyThread extends Thread {
        private Object theObject;

        public MyThread(Object o) {
            this.theObject = o;
        }
        //..
    }
}