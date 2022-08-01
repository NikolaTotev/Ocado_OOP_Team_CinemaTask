package com.ocadoacademy.cinema;

public class Movie {
    private final String name;
    private final Genre genre;
    private final int lengthOfMovie; //in minutes
    private final String actors;
    private final String director;

    public Movie(String name, Genre genre, int lengthOfMovie, String actors, String director) throws IllegalArgumentException {
        assertMovieInputData(name, genre, lengthOfMovie, actors, director);

        this.name = name;
        this.genre = genre;
        this.lengthOfMovie = lengthOfMovie;
        this.actors = actors;
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "Name: " + name + '\'' +
                ", Genre: " + genre +
                ", Length of movie: " + lengthOfMovie +
                ", Actors: " + actors + '\'' +
                ", Director: " + director + '\'' +
                '}';
    }

    public Genre getGenre() {
        return genre;
    }

    public int getLengthOfMovie() {
        return lengthOfMovie;
    }

    private void assertMovieInputData(String name, Genre genre, int lengthOfMovie, String actors, String director) throws IllegalArgumentException {
        assertStringData(name);
        assertStringData(actors);
        assertStringData(director);
        assertLengthOfMovie(lengthOfMovie);
    }

    private void assertStringData(String data) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("String data is null");
        }
    }

    private void assertLengthOfMovie(int lengthOfMovie) throws IllegalArgumentException {
        if (lengthOfMovie <= 0) {
            throw new IllegalArgumentException("Length of movie must be a positive number");
        }
    }

    private void assertGenre(Genre genre) throws IllegalArgumentException {
        if (genre == null) {
            throw new IllegalArgumentException("Invalid genre data");
        }
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }
}
