package com.tsystems.javaschool.custom;

import java.io.Serializable;
import java.util.Random;

public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private final long id;

    private final String text;

    public Message(String text) {
        this.id = System.currentTimeMillis();
        this.text = text;
    }
    
    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }
    
    public String toString() {
        return "[" + id + "] " + text;
    }

}