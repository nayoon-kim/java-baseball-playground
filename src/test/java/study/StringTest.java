package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1", "2");
    }

    @Test
    void split_have_no_delimiter() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void substring() {
        String actual = "(1, 2)";
        actual = actual.substring(1, actual.length() - 1);
        assertThat(actual).isEqualTo("1, 2");
    }

    @Test
    @DisplayName("chatAt Non Exception")
    void charAt() {
        char actual = "012345".charAt(5);
        assertThat(actual).isEqualTo('5');
    }

    @Test
    @DisplayName("charAt assertThatThrownBy")
    void charAt_ExceptionTest1() {
        String actual = "12345";
        assertThatThrownBy(() -> {
            actual.charAt(5); 
        }).isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range: " + actual.length());
    }

    @Test
    @DisplayName("charAt assertThatExceptionOfType")
    void charAt_ExceptionTest2() {
        String actual = "12345";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
          .isThrownBy(() -> {
              actual.charAt(5);
        }).withMessageMatching("String index out of range: " + actual.length());
    }
}
