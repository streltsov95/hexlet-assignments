package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        String[] words = sentence.split(" ");
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else if (!word.equals("")) {
                wordCount.put(word, 1);
            }
        }
        return wordCount;
    }

    public static String toString(Map<String, Integer> wordCount) {
        var result = new StringBuilder();
        result.append("{");
        if (!wordCount.isEmpty()) {
            result.append("\n");
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                result.append("  ");
                result.append(entry.getKey());
                result.append(":");
                result.append(" ");
                result.append(entry.getValue());
                result.append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}
//END
