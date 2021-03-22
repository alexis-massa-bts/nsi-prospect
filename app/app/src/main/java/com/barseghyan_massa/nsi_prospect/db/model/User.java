package com.barseghyan_massa.nsi_prospect.db.model;

import java.sql.Date;

public class User {
    String name;
    String lastname;
    String login;
    String password;
    String phone;
    String mail;
    Date createdAt;

    /*=====================================Constructors===========================================*/
    public User() {
        this.name = "default";
        this.lastname = "default";
        this.login= "default";
        this.password = "default";
        this.phone = "0000000000";
        this.mail = "default@default.default";
        this.createdAt = new Date(System.currentTimeMillis());
    }

    public User(String name, String lastname, String password) {
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.createdAt = new Date(System.currentTimeMillis());
    }

    public User(String name, String lastname, String password, String phone, String mail) {
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.phone = phone;
        this.mail = mail;
        this.createdAt = new Date(System.currentTimeMillis());
    }

    /*=====================================Getters================================================*/
    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLogin() {
        return login;
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

    public String getCreatedAt() {
        return String.valueOf(createdAt);
    }

    /*=====================================Setters================================================*/
    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
                ", createdAt=" + createdAt +
                '}';
    }
}
