package exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class SorterTest {

    List<Map<String, String>> usersList;

    @BeforeEach
    public void initEach() {
        this.usersList = List.of(
                Map.of("name", "Leonid Isaev", "birthday", "1983-08-21", "gender", "male"),
                Map.of("name", "Marina Gavrilova", "birthday", "1991-06-11", "gender", "female"),
                Map.of("name", "Gusakov Vitaliy", "birthday", "1995-10-15", "gender", "male"),
                Map.of("name", "Strelnikova Maria", "birthday", "1980-03-09", "gender", "female"),
                Map.of("name", "Stanislav Ivanov", "birthday", "1986-12-13", "gender", "male")
        );
    }

    @Test
    void testSorted() {
        List<String> actual = List.of("Leonid Isaev", "Stanislav Ivanov", "Gusakov Vitaliy");
        List<String> test = Sorter.takeOldestMans(usersList);
        assertThat(actual).isEqualTo(test);
    }

    @Test
    void testSortedZero() {
        List<Map<String, String>> usersList1 = new ArrayList<>();
        List<String> actual = new ArrayList<>();
        List<String> test = Sorter.takeOldestMans(usersList1);
        assertThat(actual).isEqualTo(test);
    }
}
// END


