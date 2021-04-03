package service1;

import service2.annotations.JsonObject;
import service2.annotations.JsonPrimitive;
import service2.annotations.JsonSerializable;

@JsonSerializable
public final class Date {
    public static final int DAY_LOWER_BOUND = 1;
    public static final int DAY_UPPER_BOUND = 30;

    @JsonPrimitive
    private int day;
    @JsonObject
    private Time time;

    public Date(int day, Time time)  throws Exception {
        if (day < DAY_LOWER_BOUND || day > DAY_UPPER_BOUND) {
            throw new Exception("Day must be [1-30]");
        }
        this.day = day;
        this.time = time;
    }

    public Date(int day, int hour, int minute) throws Exception {
        this(day, new Time(hour, minute));
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) throws Exception {
        if (day < DAY_LOWER_BOUND || day > DAY_UPPER_BOUND) {
            throw new Exception("Day must be [1-30]");
        }
        this.day = day;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setTime(int hour, int minute) throws Exception {
        this.time = new Time(hour, minute);
    }

    @Override
    public String toString() {
        String day = (getDay() < 10) ? ("0" + getDay()) : String.valueOf(getDay());
        return day + " day " + getTime().toString();
    }
}
