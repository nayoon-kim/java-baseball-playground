public class Result {
    private int ball;
    private int strike;
    private int nothing;

    public Result(int ball, int strike, int nothing) {
        this.ball = ball;
        this.strike = strike;
        this.nothing = nothing;
    }

    public int getBall() {
        return this.ball;
    }

    public int getStrike() {
        return this.strike;
    }

    public int getNothing() {
        return this.nothing;
    }

    public boolean isSuccess() {
        if (this.strike == 3) {
            return true;
        }
        return false;
    }
}
