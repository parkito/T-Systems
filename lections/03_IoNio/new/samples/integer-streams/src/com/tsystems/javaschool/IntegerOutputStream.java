package com.tsystems.javaschool;

import java.io.*;

public class IntegerOutputStream extends FilterOutputStream {

    private final byte[] intBuffer = new byte[Integer.SIZE / Byte.SIZE];
    
    public IntegerOutputStream(OutputStream out) {
        super(out);
    }

    public synchronized void writeInt(int x) throws IOException {
        for (int i = intBuffer.length - 1; i > -1; --i) {
			intBuffer[i] = (byte) ((x >> (8 * (intBuffer.length - i - 1))) & 0xff);
        }
        write(intBuffer);
    }
    
}