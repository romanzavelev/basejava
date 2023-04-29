package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.*;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int STORAGE_LIMIT = 10000;
    protected int size = 0;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    @Override
    public List<Resume> doGetAll() {
        return new ArrayList<>(Arrays.asList(storage).subList(0, size));
    }

    public int size() {
        return size;
    }

    @Override
    protected void doUpdate(Resume r, Integer index) {
        storage[index] = r;
    }

    @Override
    protected void doDelete(Integer searchKey) {
        fillDeletedElement(searchKey);
        storage[size - 1] = null;

        size--;
    }

    @Override
    protected void doSave(Resume r, Integer searchKey) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            insertElement(r);
            size++;
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected boolean isExist(Integer index) {
        return index >= 0;
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        return storage[searchKey];
    }

    protected abstract void insertElement(Resume r);

    protected abstract void fillDeletedElement(Integer searchKey);

}
