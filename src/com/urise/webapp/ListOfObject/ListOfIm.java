package com.urise.webapp.ListOfObject;

import java.util.ArrayList;
import java.util.List;

public class ListOfIm<T extends Comparable<T>> implements ListOf {

    Object[] mas = new Object[10];
    int light = 0;

    @Override
    public void add(Comparable obj) {
        mas[light] = (T) obj;
        light++;
    }

    @Override
    public T get(int index) {
        return (T) mas[index];
    }


    @Override
    public T max() {
        T maxT = (T) mas[0];
        for (int i = 1; i < light; i++) {
            T tel = (T) mas[i];
            if (tel.compareTo(maxT) > 0) {
                maxT = (T) mas[i];
            }
        }
        return maxT;
    }
}
