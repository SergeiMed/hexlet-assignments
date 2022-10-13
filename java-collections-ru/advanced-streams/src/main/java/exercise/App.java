package exercise;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
public class App {

    public static void main(String[] args) {
    }

    public static String getForwardedVariables(String text) {
        String[] result = text.split("\n");
        return Arrays.stream(result)
                .filter(line -> line.startsWith("environment="))
                .map(line1 -> line1.replaceAll("environment=", ""))
                .map(string -> string.split(","))
                .flatMap(Stream::of)
                .map(line2 -> line2.replaceAll("\"", ""))
                .peek(System.out::println)
                .filter(line3 -> line3.startsWith("X_FORWARDED_"))
                .map(line4 -> line4.replaceAll("X_FORWARDED_", ""))
                .peek(System.out::println)
                .collect(Collectors.joining(","));
    }
}
//END
