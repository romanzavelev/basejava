package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.ListSection;
import com.urise.webapp.model.Resume;
import com.urise.webapp.model.SectionType;
import com.urise.webapp.model.TextSection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {
    protected Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    private static final Resume RESUME_1 = new Resume(UUID_1, "name1");
    private static final Resume RESUME_2 = new Resume(UUID_2, "name2");
    private static final Resume RESUME_3 = new Resume(UUID_3, "name3");

    {
        RESUME_1.addSection(SectionType.OBJECTIVE, new TextSection("Позиция1"));
        RESUME_1.addSection(SectionType.PERSONAL, new TextSection("Персональная информация"));
        RESUME_1.addSection(SectionType.ACHIEVEMENT, new ListSection("Достижение1","Достижение2","Достижение3"));
        RESUME_1.addSection(SectionType.QUALIFICATIONS, new ListSection("Квалификация1","Квалификация2","Квалификация3"));
        RESUME_1.addSection(SectionType.EXPERIENCE,
    }

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME_3);
        storage.save(RESUME_1);
        storage.save(RESUME_2);
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
        Resume newResume = new Resume(RESUME_2.getUuid(), RESUME_2.getFullName());
        storage.update(newResume);
        assertSame(newResume, storage.get(UUID_2));
    }

    @Test(expected = ExistStorageException.class)
    public void existSave()  {
        storage.save(new Resume(RESUME_3.getUuid(),RESUME_3.getFullName()));
    }

    @Test
    public void save() {
        int size = storage.size();
        Resume newResume = new Resume("uuid4", "Никонов Иван Петрович");
        storage.save(newResume);
        assertEquals(newResume, storage.get("uuid4"));
        assertEquals(size + 1, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteExist()  {
        storage.delete("uuid5");
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        int size = storage.size();
        storage.delete(UUID_3);
        assertEquals(size - 1, storage.size());
        storage.get(UUID_3);
    }

    @Test
    public void get() {
        Resume resume = storage.get(UUID_3);
        Resume testResume = new Resume(RESUME_3.getUuid(), RESUME_3.getFullName());
        assertEquals(testResume, resume);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist()  {
        storage.get("dummi");
    }

    @Test
    public void getAllSorted() {
        List<Resume> expectedArray = Arrays.asList(RESUME_1,RESUME_2,RESUME_3);
        List<Resume>  actualArray = storage.getAllSorted();
        assertEquals(expectedArray, actualArray);
    }
}