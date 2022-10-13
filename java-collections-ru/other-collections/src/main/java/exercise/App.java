package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
public class App {

    public static void main(String[] args) {
    }

    public static Map<String, String> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, String> sortedResult = new LinkedHashMap<>();
        Set<String> result = new TreeSet<>();
        result.addAll(map1.keySet());
        result.addAll(map2.keySet());
        for (String key : result) {
            if (!map1.containsKey(key)) {
                sortedResult.put(key, "added");
            } else if (!map2.containsKey(key)) {
                sortedResult.put(key, "deleted");
            } else if (map1.get(key).equals(map2.get(key))) {
                sortedResult.put(key, "unchanged");
            } else {
                sortedResult.put(key, "changed");
            }
        }
        return sortedResult;
    }
}
//END
