package org.example;

import java.util.HashMap;
import java.util.Map;

public class databaseService {

    private Map<String, String> database;
    private boolean connected;

    public void connect() {
        database = new HashMap<>();
        connected = true;
        System.out.println("Database Connected");
    }

    public void disconnect() {
        connected = false;
        System.out.println("Database Disconnected");
    }

    public void insert(String key, String value) {

        if (!connected) {
            throw new IllegalStateException("Database not connected");
        }

        database.put(key, value);
    }

    public String fetch(String key) {

        if (!connected) {
            throw new IllegalStateException("Database not connected");
        }

        return database.get(key);
    }
}