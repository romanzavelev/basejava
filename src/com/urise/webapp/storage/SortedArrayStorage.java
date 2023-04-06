package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    @Override
    protected void insertElement(Resume r, int index) {
       int insIdx = -index - 1;
       System.arraycopy(storage, insIdx, storage, insIdx + 1, size - insIdx);
       storage[insIdx] = r;
    }

    @Override
    protected void doDelete(Object searchKey) {
        int index = (Integer) searchKey;
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(storage, index + 1, storage, index, numMoved);
        } else {
            storage[index] = null;
        }
        size--;
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void fillDeletedElement(Integer index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(storage, index + 1, storage, index, numMoved);
        }
    }
}
