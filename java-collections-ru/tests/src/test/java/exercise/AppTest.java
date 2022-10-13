package exercise;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {

    List<Integer> numbers;

    @BeforeEach
    void installList() {
        this.numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(15);
        numbers.add(20);
    }

    @Test
    void testTake() {
        // BEGIN
        List<Integer> testList = App.take(numbers, 4);
        List<Integer> rightList = numbers;
        rightList.remove(4);
        Assertions.assertArrayEquals(rightList.toArray(), testList.toArray());

        // END
    }

    @Test
    void testTake_when_null() {
        List<Integer> testList = App.take(numbers, 0);
        Assertions.assertTrue(testList.isEmpty());
    }

    @Test
    void testTake_when_Index_Out_Of_Bounds_Exception() {
        List<Integer> testList = App.take(numbers, 10);
        Assertions.assertArrayEquals(numbers.toArray(), testList.toArray());
    }

    @Test
    void testTake_when_listIsEmpty() {
        List<Integer> listIsEmpty = new ArrayList<>();
        List<Integer> testList = App.take(listIsEmpty, 0);
        Assertions.assertTrue(testList.isEmpty());
    }
}
