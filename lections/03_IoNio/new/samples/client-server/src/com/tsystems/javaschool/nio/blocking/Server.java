package com.tsystems.javaschool.nio.blocking;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;

public class Server {

    private static final ByteBuffer RECV_BUF = ByteBuffer.allocate(10);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ServerSocketChannel server = ServerSocketChannel.open()) {
            server.bind(new InetSocketAddress(8080));
            System.out.println("Listening on 8080 at localhost");
            while (true) {
                try (SocketChannel client = server.accept()) {
                    System.out.println("Processing new connection from " + client.socket().getRemoteSocketAddress());
                    receive(client);
                    send(client, "Hello, I'm a server!");
                }
            }
        }
    }

    private static void send(SocketChannel client, String m) throws IOException {
        SocketAddress sockAddr = client.socket().getRemoteSocketAddress();
        System.out.println("Sending a message to " + sockAddr + ": " + m);
        ByteBuffer outBuf = ByteBuffer.wrap(m.getBytes());
        while (outBuf.hasRemaining()) {
            client.write(outBuf);
        }
        client.shutdownOutput();
    }

    private static void receive(SocketChannel client) throws IOException {
        SocketAddress sockAddr = client.socket().getRemoteSocketAddress();
        System.out.print("Receiving a message from " + sockAddr + ": ");
        RECV_BUF.clear();
        while (client.read(RECV_BUF) != -1) {
            RECV_BUF.flip(); // two times flip ???
            while (RECV_BUF.hasRemaining()) {
                System.out.print((char)RECV_BUF.get());
            }
            RECV_BUF.flip();
        }
        System.out.println();
    }

}