package org.example;

@FunctionalInterface
public interface AdvancedProcessor {
    String process(String input);

    default void print(String input) {
        System.out.println("Traitement de : " + input);
    }

    static void infos(){
        System.out.println("Interface fonctionnelle personnalisée pour le traitement de string");
    }
}
