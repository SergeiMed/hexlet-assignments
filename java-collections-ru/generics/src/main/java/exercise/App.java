package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// BEGIN
public class App {

    public static void main(String[] args) {
    }

    public static List<Map<String, String>> findWhere(List<Map<String, String>> library, Map<String, String> book) {
        List<Map<String, String>> hitList = new ArrayList<>();
        for (Map<String, String> libraryBook : library) {
            if (isContains(libraryBook, book)) {
                hitList.add(libraryBook);
            }
        }
        return hitList;
    }

    public static boolean isContains(Map<String, String> libraryBook, Map<String, String> book) {
        for (Map.Entry<String, String> parameter: book.entrySet()) {
            if (!libraryBook.get(parameter.getKey()).equals(parameter.getValue())) {
                return false;
            }
        }
        return true;
    }
}

//END
