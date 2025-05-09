import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CheckersGame {

    private final int frameSize = 800;

    public CheckersBoard board;

    public void initializeGame() {
        JFrame frame = new JFrame("Checkers");
        frame.setSize(frameSize, frameSize);
        frame.setVisible(true);
        board = new CheckersBoard(frameSize);
        frame.add(board);
    }

    public void startGame() {
        CheckersGame game = new CheckersGame();
    }

    public void endGame() {}

    public void play() {
        initializeGame();
        startGame();
        endGame();
    }
}
