package com.barseghyan_massa.nsi_prospect.db.model;

import java.sql.Date;
import java.util.ArrayList;

public class Prospect {
    String name;
    String lastname;
    String phone;
    String mail;
    String notes;
    Date createdAat;

    /*=====================================Constructors===========================================*/
    public Prospect() {
        this.name = "default";
        this.lastname = "default";
        this.phone = "default";
        this.mail = "default";
        this.notes = "default";
        this.createdAat = new Date(System.currentTimeMillis());
    }

    public Prospect(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
        this.createdAat = new Date(System.currentTimeMillis());
    }

    public Prospect(String name, String lastname, String phone, String mail, String notes, int siret) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.mail = mail;
        this.notes = notes;
        this.createdAat = new Date(System.currentTimeMillis());
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

    public String getCreatedAat() {
        return String.valueOf(createdAat);
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

    public void setCreatedAat(Date createdAat) {
        this.createdAat = createdAat;
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
                '}';
    }
}
