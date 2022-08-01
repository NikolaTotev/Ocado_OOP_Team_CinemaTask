package com.ocadoacademy.cinema;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private final List<Projection> projectionList = new ArrayList<>();
    private final List<Movie> movies = new ArrayList<>();
    private final List<ViewingRoom> rooms = new ArrayList<>();
    private static final int PRICE_OF_TICKET = 10; // in levs

    private String printActors(List<String> actors) {
        String result = "List of movies with actors ";
        for (int i = 0; i < actors.size(); i++) {
            if (i == actors.size() - 1) {
                result += actors.get(i) + "\n";
            }
            result += actors.get(i) + ", ";
        }
        return result;
    }
    private int getReservedSeatsForMovie(Movie movie) throws IllegalArgumentException{
        if(movie == null){
            throw new IllegalArgumentException("No such movie.");
        }
        int count = 0;
        for(Projection current : projectionList){
            if(current.getMovie().equals(movie)){
                count += current.getCountOfReservedSeats();
            }
        }
        return count;
    }

    private Movie findLeastProfitable(){
        Movie result = null;
        int currentMin = Integer.MAX_VALUE;
        for(Movie currentMovie : movies){
            int currentReserved = getReservedSeatsForMovie(currentMovie)
            if(currentMin > currentReserved){
                currentMin = currentReserved;
                result = currentMovie;
            }
        }
        return result;
    }
    private void removeAllProjectionsOfMovie(Movie movie){
        //TODO

    }
    public boolean addNewMovie(Movie movie) {
        // some logic here
        return false;
    }

    private String listProjectionsForMovie(Movie movie) throws IllegalArgumentException {
        if (movie == null) {
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

    public String listMoviesByGenre(Genre genre) throws IllegalArgumentException {
        if (genre == null) {
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

    public String listOfMoviesByDirector(String director) throws IllegalArgumentException {
        if (director == null) {
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

    public String listOfMoviesByActors(List<String> actors) throws IllegalArgumentException {
        if (actors == null) {
            throw new IllegalArgumentException("List of actors cannot be empty.");
        }
        String result = printActors(actors);
        int count = 1;
        for(Movie current : movies){
            if(current.areActorsInMovie(actors)){
                result += count + current.getName() + "\n";
                count++;
            }
        }
        return result;
    }

    public String listProjections() {
        String result = "";
        for (Movie current : movies) {
            result += listProjectionsForMovie(current);
        }
        return result;
    }
    public boolean removeLeastProfitableMovie(){
        Movie toRemove = findLeastProfitable();
        if(toRemove == null){
            return false;
        }
        movies.remove(toRemove);
        // remove all projections of this movie
        return true;
    }
}
