package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage<String> {

    protected Map<String, Resume> storage = new HashMap<>();

    @Override
    protected void doSave(Resume r, String searchKey) {
        storage.put(searchKey, r);
    }

    @Override
    protected void doUpdate(Resume r, String searchKey) {
        storage.put(searchKey, r);
    }

    @Override
    protected void doDelete(String searchKey) {
        storage.remove(searchKey);
    }

    @Override
    protected Resume doGet(String searchKey) {
        return storage.get(searchKey);
    }

    @Override
    public List<Resume> doGetAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    protected boolean isExist(String searchKey) {
        return storage.containsKey(searchKey);
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }
}