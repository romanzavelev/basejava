package com.urise.webapp;

import com.urise.webapp.model.SectionType;

public class TestSingelton {

    private static TestSingelton instance;

    public static TestSingelton getInstance() {
        if (instance == null) {
            instance = new TestSingelton();
        }
        return instance;
    }

    private TestSingelton() {

    }

    public static void main(String[] args) {
        for (SectionType type : SectionType.values()) {
            System.out.println(type.getTitle());
        }
    }

}
