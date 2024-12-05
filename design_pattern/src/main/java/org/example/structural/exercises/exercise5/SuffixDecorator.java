package org.example.structural.exercises.exercise5;

public class SuffixDecorator extends TextDecorator {
    public SuffixDecorator(Text text) {
        super(text);
    }

    @Override
    public String transform() {
        return super.transform() + "suffix";
    }
}
