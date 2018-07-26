package com.fitbit.model;

public class HeartValue {
    private HeartRateZones[] heartRateZones;
    private int restingHeartRate;

    public HeartRateZones[] getHeartRateZones() {
        return heartRateZones;
    }

    public void setHeartRateZones(HeartRateZones[] heartRateZones) {
        this.heartRateZones = heartRateZones;
    }

    public int getRestingHeartRate() {
        return restingHeartRate;
    }

    public void setRestingHeartRate(int restingHeartRate) {
        this.restingHeartRate = restingHeartRate;
    }
}
