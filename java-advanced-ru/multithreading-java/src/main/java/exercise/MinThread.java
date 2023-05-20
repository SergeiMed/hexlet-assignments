package exercise;

import java.util.Arrays;
import java.util.OptionalInt;

// BEGIN
public class MinThread extends Thread {

    private static int[] massive;
    private static int minValue;

    @Override
    public void run() {
        OptionalInt max = Arrays.stream(massive).min();
        minValue = max.getAsInt();
    }

    public MinThread(int[] massive) {
        MinThread.massive = massive;
    }

    public int getMinValue() {
        return minValue;
    }
}
// END
