public class Calculator {
    int add(int i, int j) {
        return i + j;
    }
    int subtract(int i, int j) {
        return i - j;
    }
    int multiply(int i, int j) {
        return i * j;
    }
    int divide(int i, int j) {
        return i / j;
    }
    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.add(3, 4));
        System.out.println(c.subtract(5, 4));
        System.out.println(c.multiply(2, 6));
        System.out.println(c.divide(8, 4));
    }
}