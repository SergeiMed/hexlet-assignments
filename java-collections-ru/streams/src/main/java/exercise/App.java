package exercise;

import java.util.Arrays;
import java.util.List;

// BEGIN
public class App {

    private static final List<String> FREE_DOMAINS = Arrays.asList("@gmail.com", "@yandex.ru", "@hotmail.com");

    public static void main(String[] args) {
    }

    public static long getCountOfFreeEmails(List<String> emailList) {
        return emailList.stream()
                .filter(email -> FREE_DOMAINS.contains(email.substring(email.lastIndexOf("@")))).
                count();
    }
}
// END
