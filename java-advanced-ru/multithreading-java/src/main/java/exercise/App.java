package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static void main(String[] args) {
    }

    public static Map<String, Integer> getMinMax(int[] massive) {
        MinThread minThread = new MinThread(massive);
        MaxThread maxThread = new MaxThread(massive);

        minThread.start();
        LOGGER.info("Thread minThread started");
        maxThread.start();
        LOGGER.info("Thread maxThread started");

        Map<String, Integer> result = new HashMap<>();
        result.put("min", minThread.getMinValue());
        result.put("max", maxThread.getMaxValue());
        System.out.println(result);

        try {
            minThread.join();
            LOGGER.info("Thread minThread stopped");
            maxThread.join();
            LOGGER.info("Thread maxThread stopped");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    // END
}
