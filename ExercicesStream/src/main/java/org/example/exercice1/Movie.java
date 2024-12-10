package org.example.exercice1;

import java.time.LocalDate;

public class Movie {
    private String title;
    private LocalDate releaseDate;
    private String director;
    private String genre;
    private int admissionNumber;

    public Movie(String title, LocalDate releaseDate, String director, String genre, int admissionNumber) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.director = director;
        this.genre = genre;
        this.admissionNumber = admissionNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAdmissionNumber() {
        return admissionNumber;
    }

    public void setAdmissionNumber(int admissionNumber) {
        this.admissionNumber = admissionNumber;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                ", admissionNumber=" + admissionNumber +
                '}';
    }
}
