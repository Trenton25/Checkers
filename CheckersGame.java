import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CheckersGame {

    private JFrame frame;
    private final int frameSize = 800;

    public CheckersBoard board;
    public Color currentTurn;


    public CheckersGame() {
        currentTurn = Color.BLACK;
        frame = new JFrame("Checkers");
        frame.setSize(frameSize, frameSize);
        frame.setVisible(true);
        board = new CheckersBoard(frameSize, currentTurn);

        frame.add(board);
    }

    public boolean isOver() {
        if (board.tiles.isEmpty())
            return true;
        return false;
    }
}
