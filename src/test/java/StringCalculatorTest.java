import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    public StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    void split_input() {
        String[] expected = calculator.split_input("hello world");
        String[] actual = new String[]{"hello", "world"};
        for(int i = 0, size = actual.length; i < size; i++)
            assertTrue(expected[i].equals(actual[i]));
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void is_operator(String input) {
        assertTrue(calculator.is_operator(input));
    }

    @Test
    void calculate() {
        assertEquals(calculator.calculate(8, "+",4), 2);
    }

    @ParameterizedTest
    @CsvSource(value = {"+:12", "-:4", "*:32", "/:2"}, delimiter = ':')
    void calculate_paramereterized_test(String operator, String actual) {
        float expected = calculator.calculate(8, operator, 4);
        assertEquals(expected, Integer.parseInt(actual));
    }

    @Test
    void run() {
        String[] values = calculator.split_input("2 + 3 * 4 / 2");
        int expected = (int) calculator.run(values);
        assertEquals(expected, 10);
    }


}
