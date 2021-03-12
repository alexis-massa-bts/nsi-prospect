package com.barseghyan_massa.nsi_prospect.db.model;

public class Company {
    String name;
    int siret;

    /*=====================================Constructors===========================================*/
    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public Company(String name, int siret) {
        this.name = name;
        this.siret = siret;
    }

    /*=====================================Getters================================================*/
    public String getName() {
        return name;
    }

    public int getSiret() {
        return siret;
    }

    /*=====================================Setters================================================*/
    public void setName(String name) {
        this.name = name;
    }

    public void setSiret(int siret) {
        this.siret = siret;
    }

    /*=====================================Methods================================================*/

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", siret=" + siret +
                '}';
    }
}
