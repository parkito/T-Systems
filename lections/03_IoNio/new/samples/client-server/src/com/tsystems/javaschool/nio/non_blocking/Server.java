package com.tsystems.javaschool.nio.non_blocking;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class Server {

    private static final ByteBuffer RECV_BUF = ByteBuffer.allocate(10);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Selector selector = Selector.open();
        try (ServerSocketChannel server = ServerSocketChannel.open()) {
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(8080));
            System.out.println("Listening on 8080 at localhost");
            server.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                selector.select();
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> i = selectedKeys.iterator();
                while (i.hasNext()) {
                    SelectionKey key = i.next();
                    i.remove();
                    if (!key.isValid()) {
                        continue;
                    }
                    if (key.isAcceptable()) {
                        accept(key);
                    }
                    if (key.isReadable()) {
                        read(key);
                    }
                    if (key.isWritable()) {
                        write(key, "Hello, I'm a server!");
                    }
                }
            }
        }
    }
    
    private static void accept(SelectionKey key) throws IOException {
        Selector selector = key.selector();
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        SocketChannel client = server.accept();
        System.out.println("Processing new connection from " + client.socket().getRemoteSocketAddress());
        client.configureBlocking(false);
        client.register(selector, SelectionKey.OP_READ, new StringBuilder());
    }
    
    private static void read(SelectionKey key) throws IOException {
        SocketChannel client = (SocketChannel) key.channel();
        StringBuilder builder = (StringBuilder) key.attachment();
        RECV_BUF.clear();
        try {
            if (client.read(RECV_BUF) == -1) {
                key.cancel();
                client.close();
            } else {
                RECV_BUF.flip(); // two times flip ???
                while (RECV_BUF.hasRemaining()) {
                    char c = (char) RECV_BUF.get();
                    builder.append(c);
                    if (c == '!') {
                        SocketAddress sockAddr = client.socket().getRemoteSocketAddress();
                        System.out.println("Received a message from " + sockAddr + ": " + builder);
                        key.interestOps(SelectionKey.OP_WRITE);
                    }
                }
                RECV_BUF.flip();
            }
        } catch (IOException e) {
            key.cancel();
            client.close();
        }
    }

    private static void write(SelectionKey key, String m) throws IOException {
        SocketChannel client = (SocketChannel) key.channel();
        SocketAddress sockAddr = client.socket().getRemoteSocketAddress();
        System.out.println("Sending a message to " + sockAddr + ": " + m);
        ByteBuffer outBuf = ByteBuffer.wrap(m.getBytes());
        try {
            while (outBuf.hasRemaining()) {
                client.write(outBuf);
            }
            client.shutdownOutput();
            key.cancel();
        } finally {
            client.close();
        }
    }

}