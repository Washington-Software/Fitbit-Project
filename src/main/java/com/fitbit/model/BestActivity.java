package com.fitbit.model;

public class BestActivity {
    private BestDistance distance;
    private BestFloors floors;
    private BestSteps steps;

    public BestDistance getDistance() {return distance;}

    public void setDistance(BestDistance distance) {
                this.distance = distance;
    }

    public BestFloors getFloors() {return floors;}

    public void setFloors(BestFloors floors) {
            this.floors = floors;
    }

    public BestSteps getSteps() {return steps;}

    public void setSteps(BestSteps steps) {
        this.steps = steps;
    }
}
