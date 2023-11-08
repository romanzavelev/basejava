package com.urise.webapp.ListOfObject;

public class ListOfIm<T extends Comparable<T>> implements ListOf<T> {

    Object[] mas = new Object[10];
    int light = 0;

    @Override
    public void add(T obj) {
        mas[light] = obj;
        light++;
    }

    @Override
    public T get(int index) {
        return (T) mas[index];
    }


    @Override
    public T max() {
        T maxT = get(0);
        for (int i = 1; i < light; i++) {
            T tel = get(i);
            if (tel.compareTo(maxT) > 0) {
                maxT = get(i);
            }
        }
        return maxT;
    }
}
