package service1;

import service2.annotations.JsonPrimitive;
import service2.annotations.JsonSerializable;

@JsonSerializable
public final class Time {
    public final static int HOUR_LOWER_BOUND = 0;
    public final static int HOUR_UPPER_BOUND = 23;
    public final static int MINUTE_LOWER_BOUND = 0;
    public final static int MINUTE_UPPER_BOUND = 59;

    @JsonPrimitive
    private int hour;
    @JsonPrimitive
    private int minute;

    public Time(int hour, int minute) throws Exception {
        if (hour < HOUR_LOWER_BOUND || hour > HOUR_UPPER_BOUND) {
            throw new Exception("Hour must be equal [0-23]");
        }
        if (minute < MINUTE_LOWER_BOUND || minute > MINUTE_UPPER_BOUND) {
            throw new Exception("Minute must be equal [0-59]");
        }
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) throws Exception {
        if (hour < HOUR_LOWER_BOUND || hour > HOUR_UPPER_BOUND) {
            throw new Exception("Hour must be equal [0-23]");
        }
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) throws Exception {
        if (minute < MINUTE_LOWER_BOUND || minute > MINUTE_UPPER_BOUND) {
            throw new Exception("Minute must be equal [0-59]");
        }
        this.minute = minute;
    }

    public void addMinutes(int minute) throws Exception {
        int hours = minute / (MINUTE_UPPER_BOUND + 1);
        minute %= MINUTE_UPPER_BOUND + 1;
        int additional = 0;
        while (this.minute + minute > MINUTE_UPPER_BOUND) {
            ++additional;
            minute -= MINUTE_UPPER_BOUND + 1;
        }
        setHour(this.hour + hours + additional);
        setMinute(this.minute + minute);
    }

    public int getTimeInMinutes() {
        return hour * (MINUTE_UPPER_BOUND + 1) + minute;
    }

    public void setByTime(Time newTime) {
        hour = newTime.hour;
        minute = newTime.minute;
    }

    @Override
    public String toString() {
        String hour = (getHour() < 10) ? ("0" + getHour()) : String.valueOf((getHour()));
        String minute = (getMinute() < 10) ? ("0" + getMinute()) : String.valueOf(getMinute());
        return hour + ":" + minute;
    }
}
