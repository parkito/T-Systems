package com.tsystems.javaschool;

import java.io.*;

public class IntegerStreams {

    public static final String INTS_FILE = "integers";

    public static final int[] INTS = { 5, 4096, 65793, 2147483647 }; // 0x05, 0x1000, 0x10101, 0x7FFFFFFF

    public static void main(String[] args) throws IOException {
        writeIntegerValues();
        readIntegerValues();
    }
    
    private static void writeIntegerValues() throws IOException {
        try (IntegerOutputStream ios = new IntegerOutputStream(new FileOutputStream(INTS_FILE))) {
            for (int i = 0; i < INTS.length; i++) {
                int outValue = INTS[i];
                System.out.println("WRITE : " + outValue);
                ios.writeInt(outValue);
            }
        }
    }
    
    private static void readIntegerValues() throws IOException {
        try (IntegerInputStream iis = new IntegerInputStream(new FileInputStream(INTS_FILE))) {
            for (int i = 0; i < INTS.length; i++) {
                int inValue = iis.readInt();
                System.out.println("READ : " + inValue);
            }
        }
    }

}