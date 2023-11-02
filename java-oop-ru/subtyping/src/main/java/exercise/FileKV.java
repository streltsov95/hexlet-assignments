package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {
    private String path;
    private Map<String, String> dataBase;

    FileKV(String path, Map<String, String> storage) {
        this.path = path;
        this.dataBase = new HashMap<>(storage);
    }

    @Override
    public void set(String key, String value) {
        dataBase.put(key, value);
    }

    @Override
    public void unset(String key) {
        dataBase.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return dataBase.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(dataBase);
    }
}
// END
