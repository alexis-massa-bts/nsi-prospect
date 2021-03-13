package com.barseghyan_massa.nsi_prospect.db.model;

public class User {
    String name;
    String lastname;
    String password;
    String phone;
    String mail;

    /*=====================================Constructors===========================================*/
    public User() {
    }

    public User(String name, String lastname, String password) {
        this.name = name;
        this.lastname = lastname;
    }

    public User(String name, String lastname, String phone, String mail) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.mail = mail;
    }

    /*=====================================Getters================================================*/
    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }


    public String getPassword() {
        return password;
    }
    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    /*=====================================Setters================================================*/
    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    /*=====================================Methods================================================*/

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
