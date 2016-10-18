package com.tsystems.javaschool.hello;

import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ServerSocket serverSock = new ServerSocket(8080)) {
            System.out.println("Listening on 8080 at localhost");
            while (true) {
                try (Socket clientSock = serverSock.accept()) {
                    SocketAddress sockAddr = clientSock.getRemoteSocketAddress();
                    System.out.println("Processing new connection from " + sockAddr);
                    InputStream input = new BufferedInputStream(clientSock.getInputStream());
                    receive(sockAddr, input);
                    OutputStream output = new BufferedOutputStream(clientSock.getOutputStream());
                    send(sockAddr, output, "Hello, I'm a server!");
                    clientSock.shutdownOutput();  // why do we need this line ???
                }
            }
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