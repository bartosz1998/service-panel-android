package com.example.servicepanel;

public class ValueData {
    private String locationObject;
    private String dateStartEvent;
    private String dateStopEvent;

    public ValueData(String locationObject, String dateStartEvent, String dateStopEvent){
        this.locationObject = locationObject;
        this.dateStartEvent = dateStartEvent;
        this.dateStopEvent = dateStopEvent;
    }

    public String getLocationObject(){
        return locationObject;
    }

    public String getDateStartEvent(){
        return dateStartEvent;
    }

    public String getDateStopEvent(){
        return dateStopEvent;
    }
}
