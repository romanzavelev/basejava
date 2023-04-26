package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage<SK> implements Storage {

    protected static Comparator<Resume> COMPARATOR_RESUMES
            = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    public void update(Resume r) {
        SK searchKey = getExistedKey(r.getUuid());
        doUpdate(r, searchKey);
    }

    public void save(Resume r) {
        SK searchKey = getNotExistedKey(r.getUuid());
        doSave(r, searchKey);
    }

    public void delete(String uuid) {
        SK searchKey = getExistedKey(uuid);
        doDelete(searchKey);
    }

    public Resume get(String uuid) {
        SK searchKey = getExistedKey(uuid);
        return doGet(searchKey);
    }

    private SK getExistedKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK getNotExistedKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return (SK) uuid;
    }

    public  List<Resume> getAllSorted() {
        List<Resume> storageList = doGetAll();
        storageList.sort(COMPARATOR_RESUMES);
        return storageList;
    }

    protected abstract void doSave(Resume r, SK searchKey);

    protected abstract void doUpdate(Resume r, SK searchKey);

    protected abstract void doDelete(SK searchKey);

    protected abstract Resume doGet(SK searchKey);

    public abstract List<Resume> doGetAll();

    protected abstract boolean isExist(SK searchKey);

    protected abstract SK getSearchKey(String uuid);

}
