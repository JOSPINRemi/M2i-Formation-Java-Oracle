package org.example.structural.exercises.exercise5;

public class LowerCaseDecorator extends TextDecorator {
    public LowerCaseDecorator(Text text) {
        super(text);
    }

    @Override
    public String transform() {
        return super.transform().toLowerCase();
    }
}
