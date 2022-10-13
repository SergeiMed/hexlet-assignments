package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage{

    private final String filePath;

    public FileKV(String filePath, Map<String, String> initialStorage) {
        this.filePath = filePath;
        Utils.writeFile(filePath, Utils.serialize(initialStorage));
    }

    @Override
    public void set(String key, String value) {
        Map<String, String> newStorage = Utils.unserialize(Utils.readFile(filePath));
        newStorage.put(key, value);
        Utils.writeFile(filePath, Utils.serialize(newStorage));
    }

    @Override
    public void unset(String key) {
        Map<String, String> newStorage = Utils.unserialize(Utils.readFile(filePath));
        newStorage.remove(key);
        Utils.writeFile(filePath, Utils.serialize(newStorage));
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> storage = Utils.unserialize(Utils.readFile(filePath));
        return storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(Utils.unserialize(Utils.readFile(filePath)));
    }
}
// END
