package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {

    public static boolean scrabble(String symbols, String word) {
        if (symbols == null) {
            return false;
        }
        symbols = symbols.toLowerCase();
        word = word.toLowerCase();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < symbols.length(); i++) {
            list.add(symbols.charAt(i));
        }
        for (int i = 0; i < word.length(); i++) {
            Character currentChar = word.charAt(i);
            if (!list.remove(currentChar)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
//END
