package com.barseghyan_massa.nsi_prospect.db.model;

import java.sql.Date;

public class Company {
    String name;
    int siret;
    Date createdAt;

    /*=====================================Constructors===========================================*/
    public Company() {
        this.name = "default";
        this.siret = -1;
        this.createdAt = new Date(System.currentTimeMillis());
    }

    public Company(String name) {
        this.name = name;
        this.createdAt = new Date(System.currentTimeMillis());
    }

    public Company(String name, int siret) {
        this.name = name;
        this.siret = siret;
        this.createdAt = new Date(System.currentTimeMillis());
    }

    /*=====================================Getters================================================*/
    public String getName() {
        return name;
    }

    public int getSiret() {
        return siret;
    }

    public String getCreatedAt() {
        return String.valueOf(createdAt);
    }

    /*=====================================Setters================================================*/
    public void setName(String name) {
        this.name = name;
    }

    public void setSiret(int siret) {
        this.siret = siret;
    }

    public void setCreatedAat(Date createdAat) {
        this.createdAt = createdAat;
    }
    /*=====================================Methods================================================*/

    @Override
    public String toString() {
        return name + " - " + siret;
    }
}
