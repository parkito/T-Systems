package com.tsystems.javaschool.hello;

import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) throws IOException {
        try (Socket sock = new Socket("localhost", 8080)) {
            System.out.print("Connected to 8080 at localhost");
            System.out.println("Local socket address is " + sock.getLocalSocketAddress());
            SocketAddress sockAddr = sock.getRemoteSocketAddress();
            OutputStream output = new BufferedOutputStream(sock.getOutputStream());
            send(sockAddr, output, "Hello, I'm a client!");
            sock.shutdownOutput(); // why do we need this line ???
            InputStream input = new BufferedInputStream(sock.getInputStream());
            receive(sockAddr, input);
        }
    }
    
    private static void send(SocketAddress sockAddr, OutputStream output, String m) throws IOException {
        System.out.println("Sending a message to " + sockAddr + ": " + m);
        output.write(m.getBytes());
        output.flush();
    }
    
    private static void receive(SocketAddress sockAddr, InputStream input) throws IOException {
        System.out.print("Receiving a message from " + sockAddr + ": ");
        int data = input.read();
        while (data != -1) {
            System.out.print((char)data);
            data = input.read();
        }
        System.out.println();
    }

}