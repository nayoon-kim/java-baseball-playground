public class ResultView {

    public void show_result_fail(Result result) {
        String answer = "";
        if (result.getBall() > 0) {
            answer += result.getBall() + "볼 ";
        }
        if (result.getStrike() > 0) {
            answer += result.getStrike() + "스트라이크 ";
        }
        if (result.getNothing() > 0) {
            answer += "낫싱";
        }
        System.out.println(answer);
    }

    public void show_result_success() {
        print_result_success();
        ask_new_game_start();
    }
    
    public void print_result_success() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public void ask_new_game_start() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
