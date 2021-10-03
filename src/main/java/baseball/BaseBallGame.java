package baseball;

import nextstep.utils.Message;

public class BaseBallGame {
    private boolean isRunning;
    Message message;

    public BaseBallGame(Message message) {
        this.message = message;
        this.resetGame();
    }

    public void resetGame() {
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
}