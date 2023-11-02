package exercise;

import java.util.Map;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        for (Map.Entry<String, String> entry : storage.toMap().entrySet()) {
            storage.set(entry.getValue(), entry.getKey());
            storage.unset(entry.getKey());
        }
    }

    public static void main(String[] args) {
        KeyValueStorage storage = new InMemoryKV(Map.of("key", "value", "key2", "value2"));
        App.swapKeyValue(storage);
        System.out.println(storage.toMap());
    }
}
// END
