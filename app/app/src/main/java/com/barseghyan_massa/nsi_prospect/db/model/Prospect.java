package com.barseghyan_massa.nsi_prospect.db.model;

import java.util.ArrayList;

public class Prospect {
    String name;
    String lastname;
    String phone;
    String mail;
    String notes;
    int siret;
    ArrayList<Project> projects = new ArrayList<>();
    ArrayList<Event> events = new ArrayList<>();

    /*=====================================Constructors===========================================*/
    public Prospect() {
        this.name = "default";
        this.lastname = "default";
        this.phone = "default";
        this.mail = "default";
        this.notes = "default";
        this.siret = -1;
    }

    public Prospect(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Prospect(String name, String lastname, String phone, String mail, String notes, int siret) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.mail = mail;
        this.notes = notes;
        this.siret = siret;
    }



    /*=====================================Getters================================================*/
    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public String getNotes() {
        return notes;
    }

    public int getSiret() {
        return siret;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    /*=====================================Setters================================================*/
    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setSiret(int siret) {
        this.siret = siret;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    /*=====================================Methods================================================*/

    @Override
    public String toString() {
        return "Prospect{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", notes='" + notes + '\'' +
                ", company='" + siret + '\'' +
                ", projects=" + projects +
                ", events=" + events +
                '}';
    }

    //Add project
    public void addProject(Project p) {
        this.projects.add(p);
    }

    //Add event
    public void addEvent(Event e) {
        this.events.add(e);
    }
}
