package com.fitbit.model;

import java.sql.Array;
import java.sql.Date;

public class Sleep {
    public String dateOfSleep;
    public int duration;
    public int efficiency;
    public String endTime;
    public int infoCode;
    public boolean isMainSleep;
    public Levels levels;
    public String logId;
    public int minutesAfterWakeup;
    public int minutesAsleep;
    public int minutesToFallAsleep;
    public String startTime;
    public int timeInBed;
    public String type;

    public String getDateOfSleep() {
        return dateOfSleep;
    }

    public void setDateOfSleep(String dateOfSleep) {
        this.dateOfSleep = dateOfSleep;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getInfoCode() {
        return infoCode;
    }

    public void setInfoCode(int infoCode) {
        this.infoCode = infoCode;
    }

    public boolean isMainSleep() {
        return isMainSleep;
    }

    public void setMainSleep(boolean mainSleep) {
        isMainSleep = mainSleep;
    }

    public Levels getLevels() {
        return levels;
    }

    public void setLevels(Levels levels) {
        this.levels = levels;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public int getMinutesAfterWakeup() {
        return minutesAfterWakeup;
    }

    public void setMinutesAfterWakeup(int minutesAfterWakeup) {
        this.minutesAfterWakeup = minutesAfterWakeup;
    }

    public int getMinutesAsleep() {
        return minutesAsleep;
    }

    public void setMinutesAsleep(int minutesAsleep) {
        this.minutesAsleep = minutesAsleep;
    }

    public int getMinutesToFallAsleep() {
        return minutesToFallAsleep;
    }

    public void setMinutesToFallAsleep(int minutesToFallAsleep) {
        this.minutesToFallAsleep = minutesToFallAsleep;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getTimeInBed() {
        return timeInBed;
    }

    public void setTimeInBed(int timeInBed) {
        this.timeInBed = timeInBed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
