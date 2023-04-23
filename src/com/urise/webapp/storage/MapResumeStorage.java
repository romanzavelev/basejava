package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage{

    protected Map<String, Resume> storage = new HashMap<>();

    @Override
    protected void doSave(Resume r, Object resume) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected void doUpdate(Resume r, Object resume) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected void doDelete(Object resume) {
        storage.remove(((Resume) resume).getUuid());
    }


    @Override
    protected Resume doGet(Object resume) {
        return (Resume) resume;
    }

    @Override
    public List<Resume> doGetAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return storage.get(uuid);
    }

    @Override
    public void clear() {
        storage.clear();
    }

//    @Override
//    public List<Resume> getAllSorted() {
//        List sortList = new ArrayList<Resume>(storage.values());
//        sortList.sort(COMPARATOR_RESUMES);
//        return sortList;
//    }

    @Override
    public int size() {
        return storage.size();
    }

}
