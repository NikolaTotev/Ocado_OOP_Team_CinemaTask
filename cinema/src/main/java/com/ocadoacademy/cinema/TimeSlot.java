package com.ocadoacademy.cinema;

import java.time.LocalTime;

public class TimeSlot {
    private int slotStart;
    private int slotEnd;

    public TimeSlot(int slotStart, int slotEnd) {
        this.slotStart = slotStart;
        this.slotEnd = slotEnd;
    }



    public TimeSlot offsetForward (TimeSlot before, int offset){
        return new TimeSlot(before.slotStart+offset, before.slotEnd+offset);
    }

    public TimeSlot offsetBack (TimeSlot before, int offset){
        return new TimeSlot(before.slotStart-offset, before.slotEnd-offset);
    }

    public int getSlotStart() {
        return slotStart;
    }

    public int getSlotEnd() {
        return slotEnd;
    }
}
