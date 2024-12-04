package org.example.creational.exercises.exercise1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ConfigurationManager cM = ConfigurationManager.getInstance();

        Map<String, String> config = new HashMap();
        config.put("db.host", "localhost");
        config.put("db.port", "5432");
        config.put("app.name", "MyApplication");

        cM.addConfiguration(config);

        System.out.println(config);
        System.out.println(cM);
    }
}
