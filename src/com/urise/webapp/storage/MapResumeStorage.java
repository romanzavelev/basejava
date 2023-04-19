package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage{

    protected Map<Resume, Resume> storage = new HashMap<>();

    private Resume getResumeByUuid(String uuid) {
        for (Resume r : storage.values()) {
            if (r.getUuid() == uuid) return r;
        }
        return null;
    }
    @Override
    protected void doSave(Resume r, Object searchKey) {
        storage.put((Resume) searchKey, r);
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        storage.put((Resume) searchKey, r);
    }

    @Override
    protected void doDelete(Object searchKey) {
        storage.remove((Resume) searchKey);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storage.get((Resume) searchKey);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return storage.containsKey((Resume) searchKey);
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return getResumeByUuid(uuid);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        List sortList = new ArrayList<Resume>(storage.values());
        sortList.sort(Comparator.comparing((Resume r) -> r.getFullName()).thenComparing((Resume r) -> r.getUuid()));
        return sortList;
    }

    @Override
    public int size() {
        return storage.size();
    }

}
