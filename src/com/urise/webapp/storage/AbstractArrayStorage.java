package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.*;

public abstract class AbstractArrayStorage<getFullName> extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected int size = 0;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    @Override
    public List<Resume> doGetAll() {
        //List<Resume> resumes = new ArrayList<>(List.of(storage));
        List list = new ArrayList<Resume>();
       for (int i = 0; i < size; i++) {
               list.add(storage[i]);
       }
        return list;
    }

    public int size() {
        return size;
    }


    @Override
    protected void doUpdate(Resume r, Object index) {
        storage[(Integer) index] = r;
    }

    @Override
    protected void doDelete(Object searchKey) {
        fillDeletedElement((Integer) searchKey);
        storage[size - 1] = null;

        size--;
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
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
    protected boolean isExist(Object index) {
        return (Integer) index >= 0;
    }
//    @Override
//    public List<Resume> getAllSorted() {
//            List<Resume>  storageSorted = new ArrayList<Resume>(List.of(storage));
//            storageSorted.sort(COMPARATOR_RESUMES);
//            return storageSorted;


//        List list = new ArrayList<Resume>();
//        for (int i = 0; i < size; i++) {
//                list.add(storage[i]);
//        }
//        list.sort(Comparator.comparing(
//                (Resume resume) -> resume.getFullName())
//                .thenComparing((Resume resume) -> resume.getUuid()));
//        return list;
 //   }


    @Override
    protected Resume doGet(Object searchKey) {
        return storage[(Integer) searchKey];
    }

    protected abstract void insertElement(Resume r);

    //protected abstract Integer getSearchKey(Resume resume);

    protected abstract void fillDeletedElement(Integer searchKey);


}
