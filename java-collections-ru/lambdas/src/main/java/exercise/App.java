package exercise;

import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
public class App {

    public static void main(String[] args) {
    }

    public static String[][] enlargeArrayImage(String[][] image) {

        return Arrays.stream(image)
                .flatMap(line -> Stream.of(line, line)
                        .map(cloneLine -> Stream.of(cloneLine)
                        .flatMap(star -> Stream.of(star, star)
                        ).toArray(String[]::new)))
                .toArray(String[][]::new);
    }

}
// END

