import java.util.Scanner;

public class InputView {

    private Scanner scanner;
    final String INPUT_GUIDE = "숫자를 입력해 주세요 : ";

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public String getInput() {
        String input = scanner.nextLine();
        return input;
    }

    public void inputGuide() {
        System.out.print(INPUT_GUIDE);
    }
}
