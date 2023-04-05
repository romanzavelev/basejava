package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void fillDeletedElement(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected void insertElement(Resume r, int index) {
        storage[size] = r;
    }

    @Override
    protected void doDelete(Object searchKey) {
        int id = (Integer) searchKey;
        if (id == size - 1) {
            storage[id] = null;
        } else {
            storage[id] = storage[size - 1];
        }
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}