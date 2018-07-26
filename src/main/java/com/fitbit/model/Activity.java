package com.fitbit.model;

public class Activity {

    private LifetimeActivities lifetime;

    private BestActivities best;

    public LifetimeActivities getLifetime() {
        return lifetime;
    }

    public void setLifetime(LifetimeActivities lifetime) {
        this.lifetime = lifetime;
    }

    public BestActivities getBest() { return best; }

    public void setBest(BestActivities best) { this.best=best;}

}
