import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int lastIndex = -1;

    void clear() {
        for (int i = 0; i <= lastIndex; i++) {
           storage[i] = null;
        }
        lastIndex = -1;
    }

    void save(Resume r) {
        lastIndex++;
        storage[lastIndex] = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i <= lastIndex; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i <= lastIndex; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                for (int j = i; j < lastIndex; j++) {
                    storage[j] = storage[j + 1];
                }
                storage[lastIndex] = null;
                lastIndex--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, lastIndex + 1);
    }

    int size() {
        return lastIndex + 1;
    }
}
