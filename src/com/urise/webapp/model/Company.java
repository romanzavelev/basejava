package com.urise.webapp.model;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;


public class Company {
    private final Link link;
    private String place;
    private List<Period> periods = new ArrayList<>();

    public Company(String name, String url, Period... periods) throws MalformedURLException {
        this(new Link(name, url), List.of(periods));
    }

    public Company(Link link, List<Period> periods) {
        this.link = link;
        this.periods = periods;
    }

    @Override
    public String toString() {
        return "Company{" +
                ", link=" + link +
                ", place='" + link + '\'' +
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
