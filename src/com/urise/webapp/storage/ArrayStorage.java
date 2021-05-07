package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    public void clear() {
       // Arrays.fill(storage, null);
        for (int i = 0; i <= size - 1; i++) {
           storage[i] = null;
        }
        size = 0;
    }

    public void save(Resume r) {
        if (size >= 10000) {
            System.out.println("ERROR");
            return;
        }
        if  (availableResume(r.getUuid())) {
            System.out.println("ERROR");
            return;
        }
        storage[size] = r;
        size++;
    }

    public void update(Resume r) {
        String uuid = r.getUuid();
        if  (! availableResume(uuid)) {
            System.out.println("ERROR");
            return;
        }
        for (int i = 0; i <= size - 1; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                storage[i] = r;
            }
        }
    }

    public Resume get(String uuid) {
        if  (! availableResume(uuid)) {
            System.out.println("ERROR");
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
        if  (! availableResume(uuid)) {
            System.out.println("ERROR");
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
