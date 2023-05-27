package com.urise.webapp.ListOfObject;

public interface ListOf<T>{
    // add an object to the list
            void add(T obj);

        // return the index-th element of the list
        T get(int index);

        // return the  largest object in the list
        //T max();
}
