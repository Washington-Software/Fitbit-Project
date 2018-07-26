package com.fitbit.model;

public class HeartRateZones {
    public float caloriesOut;
    public int max;
    public int min;
    public int minutes;
    public String name;

    public float getCaloriesOut() {
        return caloriesOut;
    }

    public void setCaloriesOut(float caloriesOut) {
        this.caloriesOut = caloriesOut;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
