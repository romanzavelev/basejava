package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public abstract int size();

    public abstract void clear();

    public abstract void update(Resume r);

    public abstract void save(Resume r);

    public abstract void delete(String uuid);

    public abstract Resume get(String uuid);

    public abstract Resume[] getAll();

    protected abstract int getIndex(String uuid);
}
