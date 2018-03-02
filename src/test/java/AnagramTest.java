import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    @Test
    void should_return_empty_string() {
        List<String> actual = Anagram.of("");
        List<String> expected = Arrays.asList("");

        assertEquals(expected, actual);
    }

    @Test
    void should_return_a_when_input_a() {
        List<String> actual = Anagram.of("a");
        List<String> expected = Arrays.asList("a");

        assertEquals(expected, actual);
    }

    @Test
    void should_return_ab_ba_when_input_ab() {
        List<String> actual = Anagram.of("ab");
        List<String> expected = Arrays.asList("ab", "ba");

        assertEquals(expected, actual);
    }

    @Test
    void should_return_correct_value_when_input_abc() {
        List<String> actual = Anagram.of("abc");
        List<String> expected = Arrays.asList(
                "abc", "acb",
                "bac", "bca",
                "cab", "cba"
        );

        assertEquals(expected, actual);
    }

    @Test
    void should_return_correct_value_when_input_abcd() {
        List<String> actual = Anagram.of("abcd");

        assertThat(actual, hasItems("abcd", "abdc", "adbc"));
    }
}