package com.ocadoacademy.cinema;

import java.time.LocalTime;
import java.util.List;

public class Schedule {

    List<TimeSlot> savedTimeSlots;

    private final LocalTime scheduleStart;
    private final LocalTime scheduleEnd;

    public Schedule(LocalTime scheduleStart, LocalTime scheduleEnd) {
        this.scheduleStart = scheduleStart;
        this.scheduleEnd = scheduleEnd;
    }

    public LocalTime addTimeSlot(int movieDuration) {

        LocalTime checkResult = checkStart(movieDuration);
        if (checkResult != null) {
            return checkResult;
        }

        checkResult = checkEnd(movieDuration);
        if (checkResult != null) {
            return checkResult;
        }

        checkResult = checkMid(movieDuration);
        return checkResult;
    }

    public LocalTime checkStart(int duration) {
        TimeSlot firstSlot = savedTimeSlots.get(0);

        int potentialSlotEnd = firstSlot.getSlotStart() - 30;
        int potentialSlotStart = potentialSlotEnd - duration;

        if (potentialSlotStart >= 0) {
            TimeSlot newSlot = new TimeSlot(potentialSlotStart, potentialSlotEnd);
            return slotStart(newSlot);
        }
        return null;
    }

    public LocalTime checkMid(int duration) {
        for (int i = 0; i < savedTimeSlots.size() - 1; i++) {

            TimeSlot slotBefore = savedTimeSlots.get(i);
            TimeSlot slotAfter = savedTimeSlots.get(i + 1);

            if (slotBefore.getSlotEnd() + slotAfter.getSlotStart() >= duration + 60) {
                int slotStart = slotBefore.getSlotEnd() + 30;
                int slotEnd = slotStart + duration;
                TimeSlot newSlot = new TimeSlot(slotStart, slotEnd);
                savedTimeSlots.add(i + 1, newSlot);
                return slotStart(newSlot);
            }
        }
        return null;
    }

    public LocalTime checkEnd(int duration) {
        TimeSlot lastSlot = savedTimeSlots.get(savedTimeSlots.size());

        int potentialSlotStart = lastSlot.getSlotEnd() + 30;
        int potentialSlotEnd = potentialSlotStart + duration;

        if (potentialSlotEnd <= maxMinutes()) {
            TimeSlot newSlot = new TimeSlot(potentialSlotStart, potentialSlotEnd);
            return slotStart(newSlot);
        }
        return null;
    }


    public int maxMinutes() {
        int hourDiff = scheduleEnd.getHour() - scheduleStart.getHour();
        int minuteSum = scheduleStart.getMinute() + scheduleEnd.getMinute();

        return hourDiff * 60 + minuteSum;
    }

    public LocalTime slotStart(TimeSlot slot) {
        return scheduleStart.plusMinutes(slot.getSlotStart());
    }


}
