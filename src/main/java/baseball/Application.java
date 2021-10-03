package baseball;

import nextstep.utils.Message;

public class Application {
    public static void main(String[] args) {
        Message message = new Message();
        BaseBallGame baseBallGame = new BaseBallGame(message);

        while(baseBallGame.isRunning()) {
            String input = baseBallGame.getInput();
            baseBallGame.setRunning(false);
        }
    }
}
