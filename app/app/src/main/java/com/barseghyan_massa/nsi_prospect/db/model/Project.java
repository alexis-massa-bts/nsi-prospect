package com.barseghyan_massa.nsi_prospect.db.model;

public class Project {
    String wording;
    String notes;

    /*=====================================Constructors===========================================*/
    public Project() {
    }

    public Project(String wording, String notes) {
        this.wording = wording;
        this.notes = notes;
    }

    /*=====================================Getters================================================*/
    public String getWording() {
        return wording;
    }

    public String getNotes() {
        return notes;
    }

    /*=====================================Setters================================================*/
    public void setWording(String wording) {
        this.wording = wording;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    /*=====================================Methods================================================*/

    @Override
    public String toString() {
        return "Project{" +
                "wording='" + wording + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
