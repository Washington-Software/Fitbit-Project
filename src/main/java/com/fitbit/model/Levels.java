package com.fitbit.model;

public class Levels {
    public Data[] data;
    public Data[] shortData;
    public LevelSummary summary;

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }

    public Data[] getShortData() {
        return shortData;
    }

    public void setShortData(Data[] shortData) {
        this.shortData = shortData;
    }

    public LevelSummary getSummary() {
        return summary;
    }

    public void setSummary(LevelSummary summary) {
        this.summary = summary;
    }
}
