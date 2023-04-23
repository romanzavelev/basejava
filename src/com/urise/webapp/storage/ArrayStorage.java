package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertElement(Resume r) {
        storage[size] = r;
    }

    @Override
    protected void fillDeletedElement(Integer index) {
        if (index == size - 1) {
            storage[index] = null;
        } else {
            storage[index] = storage[size - 1];
        }
    }

    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}