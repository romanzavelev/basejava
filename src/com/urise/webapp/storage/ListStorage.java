package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage{

    protected ArrayList<Resume> storage = new ArrayList<>();

    public void clear() {
        storage.clear();
    }

    public int size() {
        return storage.size();
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        storage.add(r);
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        storage.add((Integer) searchKey, r);
    }

    @Override
    protected void doDelete(Object searchKey) {
        storage.remove((Integer) searchKey);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storage.get((Integer) searchKey);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return false;
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return null;
    }

    public void update(Resume r) {
        int index = storage.indexOf(r);
        if (index < 0) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            storage.set(index, r);
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage.get(index);
    }


    public Resume[] getAll() {
        return storage.toArray(new Resume[storage.size()]);
    }

    protected int getIndex(String uuid) {
        for (Resume r : storage) {
            if (r.getUuid().equals(uuid)) {
                return storage.indexOf(r);
            }
        }
        return -1;
    }
}
