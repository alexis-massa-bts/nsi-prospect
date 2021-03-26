package com.barseghyan_massa.nsi_prospect.db.model;

import java.io.Serializable;
import java.sql.Date;

public class Prospect implements Serializable {
    String lastname;
    String name;
    String phone;
    String mail;
    String notes;
    Company company;
    Date createdAat;

    /*=====================================Constructors===========================================*/
    public Prospect() {
        this.lastname = "default";
        this.name = "default";
        this.phone = "default";
        this.mail = "default";
        this.notes = "default";
        this.createdAat = new Date(System.currentTimeMillis());
    }

    public Prospect(String name, String lastname) {
        this.lastname = lastname;
        this.name = name;
        this.createdAat = new Date(System.currentTimeMillis());
    }

    public Prospect(String name, String lastname, String phone, String mail, String notes) {
        this.lastname = lastname;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.notes = notes;
        this.createdAat = new Date(System.currentTimeMillis());
    }

    public Prospect(String name, String lastname, String phone, String mail, String notes, Company company) {
        this.lastname = lastname;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.notes = notes;
        this.company = company;
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

    public Company getCompany() {
        return company;
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

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCreatedAat(Date createdAat) {
        this.createdAat = createdAat;
    }

    /*=====================================Methods================================================*/

    @Override
    public String toString() {
        return capitalize(name) + " " + capitalize(lastname) + " - " + company ;
    }

    public static String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
