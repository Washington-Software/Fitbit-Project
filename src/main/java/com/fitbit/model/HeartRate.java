package com.fitbit.model;
import com.google.gson.annotations.SerializedName;

public class HeartRate {
    @SerializedName("activities-heart")
    public Heart[] activitiesHeart;

    @SerializedName("activities-heart-intraday")
    public Intraday activitiesHeartIntraday;

    public Intraday getActivitiesHeartIntraday() {
        return activitiesHeartIntraday;
    }

    public void setActivitiesHeartIntraday(Intraday activitiesHeartIntraday) {
        this.activitiesHeartIntraday = activitiesHeartIntraday;
    }

    public Heart[] getActivitiesHeart() {
        return activitiesHeart;
    }

    public void setActivitiesHeart(Heart[] activitiesHeart) {
        this.activitiesHeart = activitiesHeart;
    }
}
