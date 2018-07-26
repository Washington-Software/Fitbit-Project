package com.fitbit.model;
import com.google.gson.annotations.SerializedName;

public class StepsLog {
    @SerializedName("activities-log-steps")
    private ActivitiesLogSteps[] activitiesLogSteps;

    public ActivitiesLogSteps[] getActivitiesLogSteps() {
        return activitiesLogSteps;
    }

    public void setActivitiesLogSteps(ActivitiesLogSteps[] activitiesLogSteps) {
        this.activitiesLogSteps = activitiesLogSteps;
    }
}
