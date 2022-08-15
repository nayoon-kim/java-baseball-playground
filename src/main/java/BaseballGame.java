import java.util.Random;

public class BaseballGame {

    String answer;
    InputView input_view;
    ResultView result_view;

    public BaseballGame(InputView input_view, ResultView result_view) {
        input_view = this.input_view;
        result_view = this.result_view;
    }

    public void start_game() {
        Random random = new Random();
        answer = Integer.toString(random.nextInt(900) + 100);
    }

    public String input() {
        return input_view.get_input();
    }

    public void run_game() {
        Result result;
        start_game();
        boolean continue_game = true;
        while(continue_game) {
            String client_input = input();
            result = calculate(client_input);
            if (is_success(result)) {
                show_success_and_ask_another_game();
                continue_game = is_another_game();
            } else {
                show_fail(result);
            }
        }
    }
    public void show_fail(Result result) {
        result_view.show_result_fail(result);
    }
    public void show_success_and_ask_another_game() {
        result_view.show_result_success();
    }
    public boolean is_another_game() {
        String answer_another_game = input();
        
        if (is_yes(answer_another_game)) {
            start_game();
            return true;
        }
        return false;
    }
    
    public boolean is_yes(String answer) {
        return answer.equals("1");
    }

    public boolean is_success(Result result) {
        if (result.getStrike() == 3) {
            return true;
        }
        return false;
    }
    public Result calculate(String input) {
        int strike = calculate_strike(input);
        int ball = calculate_ball(input);
        int nothing = calculate_nothing(strike, ball);
        
        return new Result(ball, strike, nothing);
    }

    public int calculate_strike(String input) {
        int strike_num = 0;
        String[] answer_split = answer.split("");
        String[] input_split = input.split("");
        for(int i = 0, size = answer_split.length; i < size; i++) {
            if (answer_split[i] == input_split[i]) {
                strike_num++;
            }
        }
        return strike_num;
    }

    public int calculate_ball(String input) {
        int ball_num = 0;
        String[] answer_split = answer.split("");
        String[] input_split = input.split("");
        for(int i = 0, size = input_split.length; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if (i == j) continue;
                if (answer_split[i] == input_split[j]) {
                    ball_num++;
                }
            }
        }
        return ball_num;
    }

    public int calculate_nothing(int strike, int ball) {
        if (strike == 0 && ball == 0)
            return 3;
        return 0;
    }
}
