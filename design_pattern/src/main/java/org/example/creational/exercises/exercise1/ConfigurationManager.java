package org.example.creational.exercises.exercise1;

import java.util.Map;

public class ConfigurationManager {
    private static ConfigurationManager instance;

    private String host;
    private int port;
    private String name;

    private ConfigurationManager() {
    }

    public static synchronized ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "ConfigurationManager{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", name='" + name + '\'' +
                '}';
    }

    public void addConfiguration(Map<String, String> config) {
        host = config.get("db.host");
        port = Integer.parseInt(config.get("db.port"));
        name = config.get("app.name");
    }
}
