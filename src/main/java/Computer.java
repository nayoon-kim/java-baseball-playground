public class Computer {

    private ResultView result_view;
    private InputView input_view;

    public Computer() {
        result_view = new ResultView();
        input_view = new InputView();
    }

    public void baseball_game() {
        BaseballGame baseball_game = new BaseballGame(input_view, result_view);
        baseball_game.run_game();
    }
}
