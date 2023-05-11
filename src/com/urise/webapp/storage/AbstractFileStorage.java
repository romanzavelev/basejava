package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.AbstractStorage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static javax.imageio.ImageIO.doWrite;

public abstract class AbstractFileStorage extends AbstractStorage<File> {

    private File directory;
    protected  AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory must not be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath()+ " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath()+ " is not readable/wra");
        }
        this.directory = directory;
    }
    @Override
    protected void doSave(Resume r, File file) {

    }

    @Override
    protected void doUpdate(Resume r, File file) {
        try {
            file.createNewFile();
            doWrite(r, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract void doWrite(Resume r, File file);

    @Override
    protected void doDelete(File file) {

    }

    @Override
    protected Resume doGet(File file) {
        return null;
    }

    @Override
    public List<Resume> doGetAll() {
        return null;
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }
}
