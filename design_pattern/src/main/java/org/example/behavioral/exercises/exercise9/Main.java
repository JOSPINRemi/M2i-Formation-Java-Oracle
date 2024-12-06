package org.example.behavioral.exercises.exercise9;

public class Main {
    public static void main(String[] args) {
        Song song = new Song();
        Command addSong = new AddSongCommand(song);
        Command removeSong = new RemoveSongCommand(song);
        Playlist playlist = new Playlist();

        playlist.setCommand(addSong);
        playlist.executeCommand();

        playlist.setCommand(removeSong);
        playlist.executeCommand();
    }
}
