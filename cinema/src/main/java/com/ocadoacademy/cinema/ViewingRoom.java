package com.ocadoacademy.cinema;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

public class ViewingRoom {
    private final int roomNumber;
    private final int numberOfSeats;
    private Schedule schedule;
    private final LocalTime OPEN_TIME = LocalTime.of(16, 0);;
    private final LocalTime CLOSE_TIME = LocalTime.of(23, 50);

    public ViewingRoom(int roomNumber, int numberOfSeats) {
        this.roomNumber = roomNumber;
        this.numberOfSeats = numberOfSeats;

        schedule = new Schedule(OPEN_TIME, CLOSE_TIME);
    }

    public LocalTime saveTimeSlot(int movieDuration) {
        return schedule.addTimeSlot(movieDuration);
    }

    private LocalTime offSetForward(LocalTime time, LocalTime offset) {
        return time.plusHours(offset.getHour()).plusMinutes(offset.getMinute());
    }

    private LocalTime offsetBackward(LocalTime time, LocalTime offset) {
        return time.minusHours(offset.getHour()).minusMinutes(offset.getMinute());
    }

}

import java.time.LocalTime;
import java.util.List;

public class ViewingRoom {
//    private final int roomNumber;
//    private final int numberOfSeats;
//    private List<LocalTime> timeSlots;
}
