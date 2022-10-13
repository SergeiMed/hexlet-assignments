package exercise;

import java.util.Comparator;
import java.util.List;

// BEGIN
public class App {

    public static void main(String[] args) {
        CharSequence text = new ReversedSequence("abcdef");
        System.out.println(text); // "fedcba"
        System.out.println(text.charAt(1)); // 'e'
        System.out.println(text.length()); // 6
        System.out.println(text.subSequence(1, 4)); // "edc"
    }

    public static List<String> buildAppartmentsList(List<Home>  listHome, int n) {
        return listHome.stream()
                .sorted(Comparator.comparing(Home::getArea))
                .map(Home::toString)
                .limit(n)
                .toList();
    }
}
// END
