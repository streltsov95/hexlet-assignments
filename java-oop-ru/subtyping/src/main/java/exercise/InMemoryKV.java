package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class InMemoryKV implements KeyValueStorage {
    private Map<String, String> localStorage;

    InMemoryKV(Map<String, String> mainStorage) {
        this.localStorage = new HashMap<>(mainStorage);
    }

    @Override
    public void set(String key, String value) {
        localStorage.put(key, value);
    }

    @Override
    public void unset(String key) {
        localStorage.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return localStorage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(localStorage);
    }
}
// END
