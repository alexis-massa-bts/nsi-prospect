package com.chillcoding.confectionery.model;

import java.util.Date;

/**
 * Created by macha on 24/09/16.
 */
public class AndroidConfectionery {

    private String name;
    private String versionNumber;
    private int apiNumber;
    private Date releaseDate;
    private int resourceIdImage;

    public AndroidConfectionery(String name) {
        this.name = name;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public int getApiNumber() {
        return apiNumber;
    }

    public Date getCreationDate() {
        return releaseDate;
    }

    public int getResourceIdImage() {
        return resourceIdImage;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public void setApiNumber(int apiNumber) {
        this.apiNumber = apiNumber;
    }

    public void setCreationDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setResourceIdImage(int resourceIdImage) {
        this.resourceIdImage = resourceIdImage;
    }

    public String getName() {
        return name;
    }
}
