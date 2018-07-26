package com.fitbit.model;

public class Stage {
    public int count;
    public int minutes;
    public int thirtyDayAvgMinutes;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getThirtyDayAvgMinutes() {
        return thirtyDayAvgMinutes;
    }

    public void setThirtyDayAvgMinutes(int thirtyDayAvgMinutes) {
        this.thirtyDayAvgMinutes = thirtyDayAvgMinutes;
    }
}
