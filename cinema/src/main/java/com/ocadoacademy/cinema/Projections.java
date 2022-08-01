package com.ocadoacademy.cinema;


public class Projections {
    private boolean[] reservations;
    private ViewingRoom room;
    private Movie

import java.time.LocalTime;
import java.util.List;

public class Projections {
    private final boolean[] reservations;
    private final ViewingRoom room;
    private final Movie movie;
    private final LocalTime time;

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

    public Projections(ViewingRoom room, Movie movie, LocalTime time) {
        if (!isTimeValid(time)) {
            throw new IllegalArgumentException("Time must be in the interval 16:00:00 - 23:50:00");
        }
        this.room = room;
        this.movie = movie;
        this.time = time;
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
                + "Time: " + time + "\n"
                + "Taken seats: " + printTakenSeats() + "\n";
        return result;
    }


}
