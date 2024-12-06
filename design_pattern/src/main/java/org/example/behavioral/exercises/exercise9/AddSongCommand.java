package org.example.behavioral.exercises.exercise9;

public class AddSongCommand implements Command {
    private Song song;

    public AddSongCommand(Song song) {
        this.song = song;
    }

    @Override
    public void execute() {
        song.add();
    }
}
