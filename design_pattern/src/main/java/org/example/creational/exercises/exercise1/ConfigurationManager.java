package org.example.creational.exercises.exercise1;

import java.util.Map;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private Map<String, String> configuration;

    private ConfigurationManager() {
    }

    public static synchronized ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public void loadConfiguration(Map<String, String> configuration) {
        if (this.configuration == null) {
            this.configuration = configuration;
        }else {
            System.out.println("Configuration déjà chargée");
        }
    }

    public String getConfiguration(String key) {
        return configuration.getOrDefault(key, "Clé inexistante");
    }
}
