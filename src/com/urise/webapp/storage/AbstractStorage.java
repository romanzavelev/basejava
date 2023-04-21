package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    protected static Comparator COMPARATOR_RESUMES
            = Comparator.comparing((Resume r) -> r.getFullName()).thenComparing((Resume r) -> r.getUuid());
    public void update(Resume r) {
        Object searchKey = getExistedKey(r.getUuid());
        doUpdate(r, searchKey);
    }

    public void save(Resume r) {
        Object searchKey = getNotExistedKey(r.getUuid());
        doSave(r, searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = getExistedKey(uuid);
        doDelete(searchKey);
    }



    public Resume get(String uuid) {
        Object searchKey = getExistedKey(uuid);
        return doGet(searchKey);
    }

    private Object getExistedKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNotExistedKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return uuid;
    }
    protected abstract void doSave(Resume r, Object searchKey);
    protected abstract void doUpdate(Resume r, Object searchKey);
    protected abstract void doDelete(Object searchKey);

    protected abstract Resume doGet(Object searchKey);
    public abstract List<Resume> doGetAll();
    public  List<Resume> getAllSorted() {
        List<Resume> storageList = doGetAll();
        storageList.sort(COMPARATOR_RESUMES);
        return storageList;
    };
    protected abstract boolean isExist(Object searchKey);
    protected abstract Object getSearchKey(String uuid);


}
