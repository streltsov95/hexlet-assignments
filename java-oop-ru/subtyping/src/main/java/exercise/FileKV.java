package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {
    private String path;

    FileKV(String path, Map<String, String> storage) {
        this.path = path;
        var content = Utils.serialize(storage);
        Utils.writeFile(path, content);
    }

    @Override
    public void set(String key, String value) {
        var content = Utils.readFile(path);
        var mapContent = Utils.unserialize(content);
        mapContent.put(key, value);
        var changedMapContent = Utils.serialize(mapContent);
        Utils.writeFile(path, changedMapContent);
    }

    @Override
    public void unset(String key) {
        var content = Utils.readFile(path);
        var mapContent = Utils.unserialize(content);
        mapContent.remove(key);
        var changedMapContent = Utils.serialize(mapContent);
        Utils.writeFile(path, changedMapContent);
    }

    @Override
    public String get(String key, String defaultValue) {
        var content = Utils.readFile(path);
        var mapContent = Utils.unserialize(content);
        return mapContent.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        var content = Utils.readFile(path);
        return new HashMap<>(Utils.unserialize(content));
    }
}
// END
