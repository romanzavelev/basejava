package com.urise.webapp.model;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Company {

    private URL homePage;
    private String place;
    private List<Period> periods = new ArrayList<>();

    public Company(String name, String url, Period... periods) {
        this(new URL(name,url))
    }

    public Company(URL homePage, List<Period> periods) {
        this.homePage = homePage;
        this.periods = periods;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

}
