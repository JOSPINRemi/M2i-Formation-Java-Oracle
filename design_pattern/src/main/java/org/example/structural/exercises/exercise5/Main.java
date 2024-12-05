package org.example.structural.exercises.exercise5;

public class Main {
    public static void main(String[] args) {
        Text text = new PlainText();
        System.out.println(text.transform());

        Text textWithPrefix = new PrefixDecorator(text);
        System.out.println(textWithPrefix.transform());

        Text upperCaseText = new UpperCaseDecorator(textWithPrefix);
        System.out.println(upperCaseText.transform());

        Text textWithSuffix = new SuffixDecorator(upperCaseText);
        System.out.println(textWithSuffix.transform());

        Text lowerCaseText = new LowerCaseDecorator(textWithSuffix);
        System.out.println(lowerCaseText.transform());
    }
}
