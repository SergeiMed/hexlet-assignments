package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;

// BEGIN
public class Sorter {

    public static void main(String[] args) {
    }

    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        return users.stream()
                .filter(user -> user.containsValue("male"))
                .sorted(Comparator.comparing(age -> LocalDate.parse(age.get("birthday"))))
                .map(man -> man.get("name"))
                .toList();
    }
}
// END
