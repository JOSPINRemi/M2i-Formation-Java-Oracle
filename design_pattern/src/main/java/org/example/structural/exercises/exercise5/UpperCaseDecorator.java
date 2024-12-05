package org.example.structural.exercises.exercise5;

public class UpperCaseDecorator extends TextDecorator {
    public UpperCaseDecorator(Text text) {
        super(text);
    }

    @Override
    public String transform() {
        return super.transform().toUpperCase();
    }
}
