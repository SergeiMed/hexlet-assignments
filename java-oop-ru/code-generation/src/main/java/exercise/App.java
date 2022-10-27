package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

// BEGIN
public class App {

    public static void save(Path path, Car car) {
        String string = car.serialize();
        byte[] strToBytes = string.getBytes();
        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Car extract(Path path) {
        try {
            String string = Files.readString(path);
            return Car.unserialize(string);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
// END
