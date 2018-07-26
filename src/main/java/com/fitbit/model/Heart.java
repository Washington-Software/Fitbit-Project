package com.fitbit.model;

public class Heart {
    public Object[] customHeartRateZones;
    public String dateTime;
    public HeartRateZones[] heartRateZones;
    public float value;

    public Object[] getCustomHeartRateZones() {
        return customHeartRateZones;
    }

    public void setCustomHeartRateZones(Object[] customHeartRateZones) {
        this.customHeartRateZones = customHeartRateZones;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public HeartRateZones[] getHeartRateZones() {
        return heartRateZones;
    }

    public void setHeartRateZones(HeartRateZones[] heartRateZones) {
        this.heartRateZones = heartRateZones;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
