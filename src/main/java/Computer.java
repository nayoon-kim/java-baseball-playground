public class Computer {

    private InputView inputView;
    private ResultView resultView;

    public Computer() {
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void baseballGame() {
        BaseballGame baseballGame = new BaseballGame(inputView, resultView);
        baseballGame.runGame();
    }
}
