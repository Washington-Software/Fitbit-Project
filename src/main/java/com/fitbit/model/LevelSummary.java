package com.fitbit.model;

public class LevelSummary {
    public Stage deep;
    public Stage light;
    public Stage rem;
    public Stage wake;

    public Stage getDeep() {
        return deep;
    }

    public void setDeep(Stage deep) {
        this.deep = deep;
    }

    public Stage getLight() {
        return light;
    }

    public void setLight(Stage light) {
        this.light = light;
    }

    public Stage getRem() {
        return rem;
    }

    public void setRem(Stage rem) {
        this.rem = rem;
    }

    public Stage getWake() {
        return wake;
    }

    public void setWake(Stage wake) {
        this.wake = wake;
    }
}
