package com.tsystems.javaschool;

import java.io.*;

public class IntegerInputStream extends FilterInputStream {

    private final byte[] intBuffer = new byte[Integer.SIZE / Byte.SIZE];
    
    public IntegerInputStream(InputStream in) {
        super(in);
    }

    public synchronized int readInt() throws IOException {
        int result = 0;
        readFully(intBuffer);
        for (int i = 0; i < intBuffer.length; i++) {
            result |= (intBuffer[i] & 0xff) << (8 * (intBuffer.length - i - 1));
        }
        return result;
    }
    
    private void readFully(byte[] b) throws IOException {
        int off = 0, len = b.length, read;
        while (len > 0 && (read = read(b, off, len)) != -1) {
            len = len - read;
            off = off + read;
        }
    }

}