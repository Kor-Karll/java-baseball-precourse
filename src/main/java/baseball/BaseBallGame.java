package baseball;

import java.util.ArrayList;
import nextstep.utils.Message;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class BaseBallGame {
    private boolean isRunning;
    Message message;
    int strike;
    int ball;
    int[] answer;

    public BaseBallGame(Message message) {
        this.message = message;
        this.resetGame();
    }

    public void resetGame() {
        resetStrikeBall();
        this.setRunning(true);
        this.answer = this.createAnswer();
    }

    private void resetStrikeBall() {
        this.strike = 0;
        this.ball = 0;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public String getInput() {
        message.getInput();

        return Console.readLine();
    }

    private int[] createAnswer() {
        int[] answer = new int[3];
        for (int i = 0; i < 3; i++) {
            answer[i] = Randoms.pickNumberInRange(1,9);
        }
        return answer;
    }

    public void checkAnswer(String input) {
        if (this.isNumber(input) && this.checkInputThreeLength(input)) {
            int[] answer = this.createIntArray(input);
            this.check(answer);
        }
    }

    private void check(int[] answer) {
        for (int i = 0; i < answer.length; i++) {
            this.checkNumber(answer[i], i);
        }

        message.getResult(this.strike, this.ball);

        if (strike == 3) {
            message.gameOver();
            this.askContinue();
            return;
        }

        this.resetStrikeBall();
    }

    private void askContinue() {
        message.askContinue();

        String input = Console.readLine();

        if (this.isNumber(input) && input.equals("1")) {
            this.resetGame();
            return;
        }
        message.getGameEnd();
        this.setRunning(false);
    }

    private void checkNumber(int number, int index) {
        for (int i = 0; i < this.answer.length; i++) {
            this.checkStrikeBall(number, index, this.answer[i] , i);
        }
    }

    private void checkStrikeBall(int number, int index, int answer_number, int answer_index) {
        if (number == answer_number && index == answer_index) {
            this.strike++;
        }

        if (number == answer_number && index != answer_index) {
            this.ball++;
        }
    }

    private int[] createIntArray(String input) {
        int[] result = new int[3];

        for (int i = 0; i < input.length() ; i++) {
            result[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        return result;
    }

    private boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            message.notNumber();
            return false;
        }
        return true;
    }

    private boolean checkInputThreeLength(String input) {
        if (input.length() != 3) {
            message.notThreeNumber();
            return false;
        }
        return true;
    }
}