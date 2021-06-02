package com.example.coronavirustracker.models;

public class LocationState {
    private String state;
    private String country;

    public int getDiffFromPreviousDay() {
        return diffFromPreviousDay;
    }

    public void setDiffFromPreviousDay(int diffFromPreviousDay) {
        this.diffFromPreviousDay = diffFromPreviousDay;
    }

    private int diffFromPreviousDay

    @java.lang.Override
    public java.lang.String toString() {
        return "LocationState{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", LatestTotalCases=" + LatestTotalCases +
                '}';
    }

    private int LatestTotalCases;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLatestTotalCases() {
        return LatestTotalCases;
    }

    public void setLatestTotalCases(int latestTotalCases) {
        LatestTotalCases = latestTotalCases;
    }
}
