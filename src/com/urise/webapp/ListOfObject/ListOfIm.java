package com.urise.webapp.ListOfObject;

import java.util.ArrayList;
import java.util.List;

public class ListOfIm<T> implements ListOf {

    List<T> mas = new ArrayList<>();

    int light = 0;

    @Override
    public void add(Object obj) {
        mas.add((T) obj);
        light++;
    }

    @Override
    public T get(int index) {
        return mas.get(index);
    }


    @Override
    public T max() {
        for (:
             ) {
            
        }
        return mas.get(0);
    }
}
