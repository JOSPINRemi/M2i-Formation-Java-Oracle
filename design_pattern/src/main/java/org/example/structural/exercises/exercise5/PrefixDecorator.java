package org.example.structural.exercises.exercise5;

public class PrefixDecorator extends TextDecorator {
    public PrefixDecorator(Text text) {
        super(text);
    }

    @Override
    public String transform() {
        return "prefix" + super.transform();
    }
}
