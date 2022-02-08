package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    @Override
    protected void fillDeletedElement(int index) {
       int numMoved = size - index - 1;
       if (numMoved > 0) {
           System.arraycopy(storage, index + 1, storage, index, numMoved);
       }
    }

    @Override
    protected void insertElement(Resume r, int index) {
       int insIdx = -index - 1;
       System.arraycopy(storage, insIdx, storage, insIdx + 1, size - insIdx);
       storage[insIdx] = r;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
