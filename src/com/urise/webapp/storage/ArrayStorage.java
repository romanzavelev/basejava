package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size - 1, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (size >= storage.length) {
            System.out.println("ERROR Массив переполнен");
            return;
        }
        if (availableResume(resume.getUuid())) {
            System.out.println("ERROR Резюме с таким uuid уже существует");
            return;
        }
        storage[size] = resume;
        size++;
    }

    public void update(Resume resume) {
        String uuid = resume.getUuid();
        if (!availableResume(uuid)) {
            System.out.println("ERROR Резюме с таким uuid не найдено");
            return;
        }
        for (int i = 0; i <= size - 1; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                storage[i] = resume;
            }
        }
    }

    public Resume get(String uuid) {
        if (!availableResume(uuid)) {
            System.out.println("ERROR Резюме с таким uuid не найдено");
            return null;
        }
        for (int i = 0; i <= size - 1; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        if (!availableResume(uuid)) {
            System.out.println("ERROR Резюме с таким uuid не найдено");
            return;
        }
        for (int i = 0; i <= size - 1; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private boolean availableResume(String uuid) {
        for (int i = 0; i <= size - 1; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return true;
            }
        }
        return false;
    }
}
