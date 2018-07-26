package com.fitbit.model;

public class Intraday {
    public DataSet[] dataset;
    public int datasetInterval;
    public String datasetType;

    public DataSet[] getDataSet() {
        return dataset;
    }

    public void setDataSet(DataSet[] dataset) {
        this.dataset = dataset;
    }

    public int getDatasetInterval() {
        return datasetInterval;
    }

    public void setDatasetInterval(int datasetInterval) {
        this.datasetInterval = datasetInterval;
    }

    public String getDatasetType() {
        return datasetType;
    }

    public void setDatasetType(String datasetType) {
        this.datasetType = datasetType;
    }
}
