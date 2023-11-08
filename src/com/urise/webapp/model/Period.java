package com.urise.webapp.model;

import java.util.Date;

public class Period {
    private Date startDate;
    private Date endDate;
    private String title;
    private String description;

    public Period(Date startDate, Date enDate, String title, String description) {
        this.startDate = startDate;
        this.endDate = enDate;
        this.title = title;
        this.description = description;
    }
}
