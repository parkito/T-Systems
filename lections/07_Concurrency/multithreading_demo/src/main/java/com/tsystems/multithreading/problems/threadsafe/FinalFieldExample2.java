package com.tsystems.multithreading.problems.threadsafe;

import java.util.Arrays;

/**
 * @author eas
 */
public class FinalFieldExample2 {
    final int[] data;
    static FinalFieldExample2 instance;

    /**
     * if finish then print (1, 2)
     */
    public FinalFieldExample2() {
        this.data = new int[] {1, 2};
    }

    /**
     * if finish then print (1, 0) or (1, 2)
     */
//    public FinalFieldExample2() {
//        this.data = new int[] {1, 0};
//        this.data[1] = 2;
//    }

    /**
     * if finish then print (1, 2)
     */
//    public FinalFieldExample2() {
//        int[] tmp = new int[]{1, 0};
//        tmp[1] = 2;
//        this.data = tmp;
//    }



    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                instance = new FinalFieldExample2();
            }
        }).start();

        while (instance == null) { }
        System.out.println(Arrays.toString(instance.data));
    }
}
