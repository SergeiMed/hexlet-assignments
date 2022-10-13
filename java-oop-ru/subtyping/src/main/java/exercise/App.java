package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {

    public static void main(String[] args) {
    }

    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> storageToMap = new HashMap<>(storage.toMap());
        for (Map.Entry<String, String> map : storageToMap.entrySet()) {
            storage.set(map.getValue(), map.getKey());
            storage.unset(map.getKey());
        }
    }
}
// END
