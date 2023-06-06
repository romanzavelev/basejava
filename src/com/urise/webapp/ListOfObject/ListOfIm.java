package com.urise.webapp.ListOfObject;

import java.util.ArrayList;
import java.util.List;

public class ListOfIm<T extends Comparable<T>> implements ListOf {

    T[] mas = (T[]) new Object[10];
    int light = 0;

    @Override
    public void add(Comparable obj) {
        mas[light] = (T) obj;
        light++;
    }

    @Override
    public T get(int index) {
        return mas[index];
    }


    @Override
    public T max() {
        T maxT = mas[0];
        for (int i = 1; i < 10; i++) {
            if (mas[i].compareTo(maxT) > 0) {
                maxT = mas[i];
            }
        }
        return maxT;
    }
}
