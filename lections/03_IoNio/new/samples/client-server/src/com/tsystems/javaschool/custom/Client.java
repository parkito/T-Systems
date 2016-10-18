package com.tsystems.javaschool.custom;

import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (Socket sock = new Socket("localhost", 8080)) {
            System.out.print("Connected to 8080 at localhost");
            System.out.println("Local socket address is " + sock.getLocalSocketAddress());
            SocketAddress sockAddr = sock.getRemoteSocketAddress();
            ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(sock.getOutputStream()));
            send(sockAddr, output, new Message("Hello, I'm a client!"));
            ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(sock.getInputStream()));
            receive(sockAddr, input);
            send(sockAddr, output, new Message("How are you today?"));
            receive(sockAddr, input);
        }
    }

    private static void send(SocketAddress sockAddr, ObjectOutputStream output, Message m) throws IOException {
        System.out.println("Sending a message to " + sockAddr + ": " + m);
        output.writeObject(m);
        output.flush();
    }

    private static void receive(SocketAddress sockAddr, ObjectInputStream input) throws IOException, ClassNotFoundException {
        System.out.print("Receiving a message from " + sockAddr + ": ");
        Message m = (Message) input.readObject();
        System.out.println(m);
    }

}