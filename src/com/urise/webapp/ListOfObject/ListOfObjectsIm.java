package com.urise.webapp.ListOfObject;

import com.urise.webapp.ListOfObject.ListOfObjects;

import java.util.List;

public class ListOfObjectsIm implements ListOfObjects {

    Object listObject[] = new Object[100];

    int light = 0;

    @Override
    public void add(Object obj) {
        listObject[light] = obj;
        light ++;
    }

    @Override
    public Object get(int index) {
        return listObject[index];
    }

    public int getLight() {
        return light;
    }
}
