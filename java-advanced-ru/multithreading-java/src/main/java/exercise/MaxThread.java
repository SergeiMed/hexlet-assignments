package exercise;

import java.util.Arrays;
import java.util.OptionalInt;

// BEGIN
public class MaxThread extends Thread{

    private static int[] massive;
    private static int maxValue;

    @Override
    public void run() {
        OptionalInt max = Arrays.stream(massive).max();
        maxValue = max.getAsInt();
    }

    public MaxThread(int[] massive) {
        MaxThread.massive = massive;
    }

    public int getMaxValue() {
        return maxValue;
    }
}
// END
