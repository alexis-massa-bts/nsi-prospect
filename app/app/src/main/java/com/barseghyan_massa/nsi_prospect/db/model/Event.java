package com.barseghyan_massa.nsi_prospect.db.model;


import java.sql.Date;

public class Event {
    String name;
    String location;
    Date statDate;
    Date endDate;

    public Event() {
    }

    public Event(String name, Date statDate, Date endDate) {
        this.name = name;
        this.statDate = statDate;
        this.endDate = endDate;
    }

    public Event(String name, String location, Date statDate, Date endDate) {
        this.name = name;
        this.location = location;
        this.statDate = statDate;
        this.endDate = endDate;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStatDate(Date statDate) {
        this.statDate = statDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Date getStatDate() {
        return statDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
