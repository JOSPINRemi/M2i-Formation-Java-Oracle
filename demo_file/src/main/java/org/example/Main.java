package org.example;

public class Main {
    public static void main(String[] args) {
//        Pour les fichiers texte
        /*TextFileHandler tfh = new TextFileHandler();
        tfh.demoTextFileOperations();*/

//        Pour les fichiers binaires
        BinaryFileHandler bfh = new BinaryFileHandler();
        bfh.demoBinaryFileOperations();
    }
}
