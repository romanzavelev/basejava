package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.UUID;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {
    private Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    public  AbstractArrayStorageTest(ArrayStorage storage) {
        this.storage = storage;
    }


    public AbstractArrayStorageTest(SortedArrayStorage storage) {
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
        String uuid = "uuid2";
        Resume oldResume = storage.get(uuid);
        Resume newResume = new Resume(uuid);
        storage.update(newResume);
        if (!oldResume.equals(newResume) || oldResume == newResume) {
            Assert.fail();
        }
    }

    @Test(expected = ExistStorageException.class)
    public void existSave() throws Exception {
        storage.save(new Resume("uuid3"));
    }

    @Test(expected = StorageException.class)
    public void OverflowSave() throws Exception {
        try {
            for (int i = 3; i < 10000; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException se) {
            Assert.fail("Overflow");
        }
        storage.save(new Resume());
    }

    @Test
    public void save() {
        Resume newResume = new Resume("uuid4");
        storage.save(newResume);
        Assert.assertEquals(storage.get("uuid4"), newResume);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteExist() throws Exception {
        storage.delete("uuid5");
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception{
        String uuid = "uuid3";
        storage.delete(uuid);
        storage.get(uuid);
    }

    @Test
    public void get() {
        String uuid = "uuid3";
        Resume r = storage.get(uuid);
        String testUuid = r.getUuid();
        Assert.assertEquals(uuid, testUuid);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummi");
    }

    @Test
    public void getAll() {
        Resume[] ar = storage.getAll();
        Assert.assertEquals(storage.size(), Arrays.stream(ar).count());
    }
}