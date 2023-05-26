package com.urise.webapp.model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Company {

    private String name;
    private String homePage;
    private String place;
    private List<Period> periods = new ArrayList<>();

    public Company(String name, String url, Period... periods) throws MalformedURLException {
        this(name, url, List.of(periods));
    }

    public Company(String name, String homePage, List<Period> periods) {
        this.homePage = homePage;
        this.periods = periods;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", homePage=" + homePage +
                ", place='" + place + '\'' +
                ", periods=" + periods +
                '}';
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

}
