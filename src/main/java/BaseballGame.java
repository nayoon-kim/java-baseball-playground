import java.util.Random;

public class BaseballGame {

    String answer;
    InputView inputView;
    ResultView resultView;

    public BaseballGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void startGame() {
        Random random = new Random();
        answer = Integer.toString(random.nextInt(900) + 100);
    }

    public String input() {
        return inputView.getInput();
    }

    public void runGame() {
        Result clientResult;
        boolean continueGame = true;

        startGame();

        while(continueGame) {
            String clientInput = input();
            clientResult = calculate(clientInput);
            if (isSuccess(clientResult)) {
                showSuccessAndAskAnotherGame();
                continueGame = isAnotherGame();
            } else {
                showFail(clientResult);
            }
        }
    }
    public void showFail(Result result) {
        resultView.showResultFail(result);
    }
    public void showSuccessAndAskAnotherGame() {
        resultView.showResultSuccess();
    }
    public boolean isAnotherGame() {
        String answerAnotherGame = input();
        
        if (isYes(answerAnotherGame)) {
            startGame();
            return true;
        }
        return false;
    }
    
    public boolean isYes(String answer) {
        return answer.equals("1");
    }

    public boolean isSuccess(Result result) {
        if (result.getStrike() == 3) {
            return true;
        }
        return false;
    }
    public Result calculate(String input) {
        int strike = calculateStrike(input);
        int ball = calculateBall(input);
        int nothing = calculateNothing(strike, ball);
        
        return new Result(ball, strike, nothing);
    }

    public int calculateStrike(String input) {
        int strikeNum = 0;
        String[] answerSplit = answer.split("");
        String[] inputSplit = input.split("");
        for(int i = 0, size = answerSplit.length; i < size; i++) {
            if (answerSplit[i] == inputSplit[i]) {
                strikeNum++;
            }
        }
        return strikeNum;
    }

    public int calculateBall(String input) {
        int ballNum = 0;
        String[] answerSplit = answer.split("");
        String[] inputSplit = input.split("");
        for(int i = 0, size = inputSplit.length; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if (i == j) continue;
                if (answerSplit[i] == inputSplit[j]) {
                    ballNum++;
                }
            }
        }
        return ballNum;
    }

    public int calculateNothing(int strike, int ball) {
        if (strike == 0 && ball == 0)
            return 3;
        return 0;
    }
}
