package com.ocadoacademy.cinema;

import java.time.LocalTime;
import java.util.List;

public class Projection {
    private final boolean[] reservations;
    private final ViewingRoom room;
    private final Movie movie;
    private final LocalTime startingTime;

    private boolean areSeatsAvailable(List<Integer> seats) {
        for (int current : seats) {
            if (reservations[current]) { //means that the seat is already reserved
                return false;
            }
        }
        return true;
    }

    private String printTakenSeats() {
        String result = "";
        for (int i = 0; i < reservations.length; i++) {
            if (reservations[i]) {
                result += i + " ";
            }
        }
        return result;
    }

    private boolean isTimeValid(LocalTime time) {
        LocalTime startingTime = LocalTime.parse("16:00:00");
        LocalTime endingTime = LocalTime.parse("23:50:00");
        return !time.isBefore(startingTime) && !time.isAfter(endingTime);
    }

    public Projection(ViewingRoom room, Movie movie, LocalTime time) {
        if (!isTimeValid(time)) {
            throw new IllegalArgumentException("Time must be in the interval 16:00:00 - 23:50:00");
        }
        this.room = room;
        this.movie = movie;
        this.startingTime = time;
        this.reservations = new boolean[room.getSeats()];
    }

    public boolean reserveSeats(List<Integer> seats) {
        if (areSeatsAvailable(seats)) {
            for (int current : seats) {
                reservations[current] = true;
            }
        } else {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        String result = "Movie: " + movie.getName() + " \n"
                + "Viewing room: " + room.getRoomNumber() + "\n"
                + "Time: " + startingTime + "\n"
                + "Taken seats: " + printTakenSeats() + "\n";
        return result;
    }

    public boolean[] getReservations() {
        return reservations;
    }

    public ViewingRoom getRoom() {
        return room;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalTime getStartingTime() {
        return startingTime;
    }

    public int getCountOfReservedSeats(){
        int count = 0;
        for(boolean current : reservations){
            if(current){
                count++;
            }
        }
        return count;
    }
}
