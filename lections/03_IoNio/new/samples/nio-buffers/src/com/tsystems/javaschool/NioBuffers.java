package com.tsystems.javaschool;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class NioBuffers {

    public static final String FILE_NAME = "largeFile";

    public static final int FILE_SIZE = 10485760; // 10 MB
    
    public static void main(String[] args) throws Exception {
        MappedByteBuffer out = new RandomAccessFile(FILE_NAME, "rw").getChannel()
            .map(FileChannel.MapMode.READ_WRITE, 0, FILE_SIZE);
        writeMappedFile(out, 100); // count equal to FILE_SIZE fails
        out.rewind(); // does not work without it
        readMappedFile(out);
    }
    
    private static void writeMappedFile(ByteBuffer bb, int count) {
        System.out.println("Writing to Memory Mapped File...");
        bb.putInt(count);
        for (int i = 0; i < count; i++) {
            bb.putChar('A'); // the same as bb.put('A') ???
        }
    }
    
    private static void readMappedFile(ByteBuffer bb) {
        System.out.println("Reading from Memory Mapped File...");
        int count = bb.getInt();
        for (int i = 0; i < count; i++) {
            System.out.print(bb.getChar()); // why not bb.getChar(i) ???
        }
        System.out.println();
    }

}