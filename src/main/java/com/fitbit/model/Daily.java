package com.fitbit.model;

public class Daily {
    private Activities activities;

    private Goals goals;

    private Summary summary;

    public Activities getActivities() {
        return activities;
    }

    public void setActivities(Activities activities) {
        this.activities = activities;
    }

    public Goals getGoals() { return goals; }

    public void setGoals(Goals goals) { this.goals=goals;}

    public Summary getSummary() { return summary; }

    public void setSummary(Summary summary ) { this.summary=summary;}
}
