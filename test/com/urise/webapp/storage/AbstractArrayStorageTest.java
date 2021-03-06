package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {
    private Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);

    public  AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(new Resume("fool"));
    }

    @Test
    public void update() {
        Resume newResume = new Resume(UUID_2);
        storage.update(newResume);
        assertSame(newResume, storage.get(UUID_2));
    }

    @Test(expected = ExistStorageException.class)
    public void existSave() throws Exception {
        storage.save(new Resume(UUID_3));
    }

    @Test(expected = StorageException.class)
    public void OverflowSave() throws Exception {
        try {
            for (int i = 3; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException se) {
           fail("???????????????????????? ?????????????????? ???????????? ??????????????");
        }
        storage.save(new Resume());
    }

    @Test
    public void save() {
        int size = storage.size();
        Resume newResume = new Resume("uuid4");
        storage.save(newResume);
        assertEquals(newResume, storage.get("uuid4"));
        assertEquals(size + 1, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteExist() throws Exception {
        storage.delete("uuid5");
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception{
        int size = storage.size();
        storage.delete(UUID_3);
        assertEquals(size - 1, storage.size());
        storage.get(UUID_3);
    }

    @Test
    public void get() {
        Resume resume = storage.get(UUID_3);
        Resume testResume = new Resume(UUID_3);
        assertEquals(testResume, resume);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummi");
    }

    @Test
    public void getAll() {
        Resume[] expectedArray = {RESUME_1, RESUME_2, RESUME_3};
        Resume[] actualArray = storage.getAll();
        assertArrayEquals(expectedArray, actualArray);
    }
}