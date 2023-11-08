package com.urise.webapp.ListOfObject;

public class ListOfObjectsIm implements ListOfObjects {

    Object[] listObject = new Object[100];

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

    public Object max() {
        Comparable maxT = (Comparable) listObject[0];
        for (int i = 1; i < 10; i++) {
            if ( listObject[i] instanceof Comparable ) {

            }

            if (maxT.compareTo(listObject[i]) > 0) {
                maxT = (Comparable) listObject[i];
            }
        }
        return maxT;
    }
}
