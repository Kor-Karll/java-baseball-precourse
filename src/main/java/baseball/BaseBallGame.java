package baseball;

import nextstep.utils.Message;

public class BaseBallGame {
    private boolean isRunning;
    Message message;
    int strike;
    int ball;

    public BaseBallGame(Message message) {
        this.message = message;
        this.resetGame();
    }

    public void resetGame() {
        this.strike = 0;
        this.ball = 0;
        this.setRunning(true);
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public String getInput() {
        message.getInput();

        return nextstep.utils.Console.readLine();
    }

    public void checkAnswer(String input) {
        if (this.isNumber(input) && this.checkInputThreeLength(input)) {
            int[] answer = this.createIntArray(input);
            this.check(answer);
        }
        this.setRunning(false);
    }

    private void check(int[] answer) {
        for (int i = 0; i < answer.length; i++) {
            //todo answer[i]
        }

        message.getResult(this.strike, this.ball);

        if (strike == 3) {
            message.gameOver();
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