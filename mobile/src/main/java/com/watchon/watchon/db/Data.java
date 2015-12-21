package com.watchon.watchon.db;

/**
 * Created by Alon on 10/12/2015.
 */
public class Data {

    // {"userdata_gyroscope":"","userdata_pulse":"","userdata_steps":""}

    private String userdata_gyroscope;
    private String userdata_pulse;
    private String userdata_steps;

    public Data() {
    }

    public String getUserdata_gyroscope() {
        return userdata_gyroscope;
    }

    public void setUserdata_gyroscope(String userdata_gyroscope) {
        this.userdata_gyroscope = userdata_gyroscope;
    }

    public String getUserdata_pulse() {
        return userdata_pulse;
    }

    public void setUserdata_pulse(String userdata_pulse) {
        this.userdata_pulse = userdata_pulse;
    }

    public String getUserdata_steps() {
        return userdata_steps;
    }

    public void setUserdata_steps(String userdata_steps) {
        this.userdata_steps = userdata_steps;
    }
}
