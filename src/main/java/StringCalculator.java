import java.util.Scanner;
import java.util.Arrays;

public class StringCalculator {
    static String[] operators = {"+", "-", "*", "/"};
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        String value = calculator.input();
        String[] values = calculator.split_input(value);

        float answer = calculator.run(values);
        System.out.println(answer);
    }

    public String input() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        scanner.close();
        return value;
    }

    public String[] split_input(String value) {
        String[] values = value.split(" ");
        return values;
    }

    public float run(String[] values) {
        float front = Integer.parseInt(values[0]);

        for (int i = 1, size = values.length; i < size; i++) {
            String value = values[i];
            if (is_operator(value))
                continue;
            front = calculate(front, values[i - 1], Integer.parseInt(value));
        }
        return front;
    }

    public boolean is_operator(String value) {
        return Arrays.asList(operators).contains(value);
    }

    public float calculate(float front, String operator, int back) {
        float result = 0;
        if (operator.equals("+"))
            result = add(front, back);
        else if (operator.equals("-"))
            result = subtract(front, back);
        else if (operator.equals("*"))
            result = multiply(front, back);
        else if (operator.equals("/"))
            result = divide(front, back);
        return result;
    }

    public float add(float x, int y) {
        return x + y;
    }
    
    public float subtract(float x, int y) {
        return x - y;
    }

    public float multiply(float x, int y) {
        return x * y;
    }

    public float divide(float x, int y) {
        return x / y;
    }
}
