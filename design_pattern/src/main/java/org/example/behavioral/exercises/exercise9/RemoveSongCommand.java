package org.example.behavioral.exercises.exercise9;

public class RemoveSongCommand implements Command {
    private Song song;

    public RemoveSongCommand(Song song) {
        this.song = song;
    }

    @Override
    public void execute() {
        song.remove();
    }
}
