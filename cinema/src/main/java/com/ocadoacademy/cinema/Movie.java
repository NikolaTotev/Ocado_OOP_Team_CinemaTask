package com.ocadoacademy.cinema;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Movie {

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private final String name;
    private final Genre genre;
    private final int lengthOfMovie; //in minutes
    private final List<String> actors;
    private final String director;

    public Movie(String name, Genre genre, int lengthOfMovie, List<String> actors, String director) throws IllegalArgumentException {
        assertMovieInputData(name, genre, lengthOfMovie, actors, director);

        this.name = name;
        this.genre = genre;
        this.lengthOfMovie = lengthOfMovie;
        this.actors = new ArrayList<>(actors);
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

    public String getName() {
        return name;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getLengthOfMovie() {
        return lengthOfMovie;
    }

    private void assertMovieInputData(String name, Genre genre, int lengthOfMovie, List<String> actors, String director) throws IllegalArgumentException {
        assertStringData(name);
        assertActors(actors);
        assertStringData(director);
        assertLengthOfMovie(lengthOfMovie);
    }

    private void assertStringData(String data) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("String data is null");
        }
    }

    private void assertActors(List<String> actors) throws IllegalArgumentException {
        if (actors == null) {
            throw new IllegalArgumentException("Actor data is invalid");
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

    public String getDirector() {
        return director;
    }

    public boolean areActorsInMovie(List<String> actors){
        return this.actors.containsAll(actors);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return lengthOfMovie == movie.lengthOfMovie && Objects.equals(name, movie.name) && genre == movie.genre && Objects.equals(actors, movie.actors) && Objects.equals(director, movie.director);
    }

}
