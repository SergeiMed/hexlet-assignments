package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {

    public static void main(String[] args) {
    }

    public static Map<String, Integer> getWordCount(String text) {
        String[] words = text.split(" ");
        Map<String, Integer> dictionary = new HashMap<>();
        if (text.equals("")) {
            return dictionary;
        }
        for (String word : words) {
            dictionary.put(word, dictionary.getOrDefault(word, 0) + 1);
        }
        return dictionary;
    }

    public static String toString(Map<String, Integer> dictionary) {
        StringBuilder builder = new StringBuilder("{");
        if (dictionary.isEmpty()) {
            return "{}";
        }
        for (String word : dictionary.keySet()) {
            Integer count = dictionary.get(word);
            builder.append("\n  ").append(word).append(": ").append(count);
        }
        builder.append("\n}");
        return builder.toString();
    }
}
//END
