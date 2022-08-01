package com.ocadoacademy.cinema;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private final List<Projection> projectionList = new ArrayList<>();
    private final List<Movie> movies = new ArrayList<>();
    private final List<ViewingRoom> rooms = new ArrayList<>();

    public boolean addNewMovie(Movie movie) {
        // some logic here
    }

    private String listProjectionsForMovie(Movie movie) throws IllegalArgumentException{
        if(movie == null){
            throw new IllegalArgumentException("No such movie.");
        }
        String result = "Projections of movie \n";
        int count = 1;
        result += movie.getName();
        for (Projection currentProjection : projectionList) {
            if (currentProjection.getMovie().getName().equals(movie.getName())) {
                result += count + " " + currentProjection.getStartingTime() + " \n";
                count++;
            }
        }
        return result;
    }

    public String listMoviesByGenre(Genre genre) throws IllegalArgumentException{
        if(genre == null){
            throw new IllegalArgumentException("No such genre.");
        }
        String result = "List of movies with genre " + genre.toString().toLowerCase() + "\n";
        int count = 1;

        for (Projection currentProjection : projectionList) {
            if (currentProjection.getMovie().getGenre().equals(genre)) {
                result += count + " " + currentProjection.getMovie().toString() + " \n";
                count++;
            }
        }
        return result;
    }

    public String listOfMoviesByDirector(String director) throws IllegalArgumentException{
        if(director == null){
            throw new IllegalArgumentException("Invalid director name.");
        }
        String result = "List of movies with director " + director + "\n";
        int count = 1;

        for (Projection currentProjection : projectionList) {
            if (currentProjection.getMovie().getDirector().equals(director)) {
                result += count + " " + currentProjection.getMovie().toString() + " \n";
                count++;
            }
        }
        return result;
    }

    

    public String listProjections() {

    }

}
