package com.urise.webapp.model;

import java.util.Date;

public class Organization {
    private SectionType type;
    private Date startDate;
    private Date enDate;
    private String place;
    private String role;
    private String items;

    public SectionType getType() {
        return type;
    }

    public void setType(SectionType type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEnDate() {
        return enDate;
    }

    public void setEnDate(Date enDate) {
        this.enDate = enDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }
}
