package exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestReversedSequence {

    private CharSequence text;

    @BeforeEach
    public void setup() {
        text = new ReversedSequence("abcdef");
    }

    @Test
    public void testToString() {
        String actual = text.toString();
        String expect = "fedcba";
        Assertions.assertEquals(actual, expect);
    }

    @Test
    public void testCharAt() {
        Character actual = text.charAt(1);
        Character expect = 'e';
        Assertions.assertEquals(actual, expect);
    }

    @Test
    public void testLength() {
        int actual = text.length();
        int expect = 6;
        Assertions.assertEquals(actual, expect);
    }

    @Test
    public void testSubSequence() {
        String actual = text.subSequence(1, 4).toString();
        String expect = "edc";
        Assertions.assertEquals(actual, expect);
    }
}
