package com.barseghyan_massa.nsi_prospect.db.model;


import java.sql.Date;

public class Event {
    String name;
    String location;
    Date startDate;
    Date endDate;

    /*=====================================Constructors===========================================*/
    public Event() {
    }

    public Event(String name, String location, Date statDate, Date endDate) {
        this.name = name;
        this.location = location;
        this.startDate = statDate;
        this.endDate = endDate;
    }

    /*=====================================Getters================================================*/
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Date getStatDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    /*=====================================Setters================================================*/
    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStatDate(Date statDate) {
        this.startDate = statDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /*=====================================Methods================================================*/

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
