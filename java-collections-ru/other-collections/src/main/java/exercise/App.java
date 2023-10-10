package exercise;

import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
public class App {
    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {

        Map<String, String> tempMap = new HashMap<>();

        for(Map.Entry<String, Object> entry : data1.entrySet()) {
            if (data2.containsKey(entry.getKey()) & data2.get(entry.getKey()).equals(entry.getValue())) {
                tempMap.put(entry.getKey(), "unchanged");
            }
            else if (data2.containsKey(entry.getKey()) & !data2.get(entry.getKey()).equals(entry.getValue())) {
                tempMap.put(entry.getKey(), "changed");
            }
            else if (!data2.containsKey(entry.getKey())) {
                tempMap.put(entry.getKey(), "deleted");
            }
        }

        for(String key : data2.keySet()) {
            if (!data1.containsKey(key)) {
                tempMap.put(key, "added");
            }
        }

        Set<String> sortedKeys = new TreeSet<>(tempMap.keySet());

        Map<String, String> result = new LinkedHashMap<>();

        for (String key : sortedKeys) {
            result.put(key, tempMap.get(key));
        }

        return result;
    }

    public static void main(String[] args) {
        Map<String, Object> data1 = new HashMap<>();
        data1.put("two", "own");
        Map<String, Object> data2 = new HashMap<>();
        data2.put("one", "eon");
        Map<String, String> expected = new LinkedHashMap<>();
        expected.put("one", "added");
        expected.put("two", "deleted");
        System.out.println(App.genDiff(data1, data2));
    }
}
//END
