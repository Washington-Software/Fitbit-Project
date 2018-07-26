package com.fitbit.model;

public class SleepLog {
    public Sleep[] sleep;

    public SleepSummary sleepSummary;

    public Sleep[] getSleep() {
        return sleep;
    }

    public void setSleep(Sleep[] sleep) {
        this.sleep = sleep;
    }


    public SleepSummary getSleepSummary() {
        return sleepSummary;
    }

    public void setSleepSummary(SleepSummary sleepSummary) {
        this.sleepSummary = sleepSummary;
    }
}
