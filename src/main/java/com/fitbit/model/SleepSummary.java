package com.fitbit.model;

public class SleepSummary {
    public Stages stages;
    public int totalMinutesAsleep;
    public int totalSleepRecords;
    public int totalTimeInBed;

    public Stages getStages() {
        return stages;
    }

    public void setStages(Stages stages) {
        this.stages = stages;
    }

    public int getTotalMinutesAsleep() {
        return totalMinutesAsleep;
    }

    public void setTotalMinutesAsleep(int totalMinutesAsleep) {
        this.totalMinutesAsleep = totalMinutesAsleep;
    }

    public int getTotalSleepRecords() {
        return totalSleepRecords;
    }

    public void setTotalSleepRecords(int totalSleepRecords) {
        this.totalSleepRecords = totalSleepRecords;
    }

    public int getTotalTimeInBed() {
        return totalTimeInBed;
    }

    public void setTotalTimeInBed(int totalTimeInBed) {
        this.totalTimeInBed = totalTimeInBed;
    }
}
