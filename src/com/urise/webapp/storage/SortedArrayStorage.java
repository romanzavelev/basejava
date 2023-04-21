package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertElement(Resume resume) {
        int insIdx = - Arrays.binarySearch(storage, 0, size, resume, COMPARATOR_RESUMES) - 1;
        if (insIdx < size - 1) {
            System.arraycopy(storage, insIdx, storage, insIdx + 1, size - insIdx);
        }
        storage[insIdx] = resume;
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
    protected Object getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void fillDeletedElement(Integer index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(storage, index + 1, storage, index, numMoved);
        }
    }
}
