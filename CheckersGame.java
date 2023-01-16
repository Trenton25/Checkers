import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CheckersGame {

    private JFrame frame;
    private final int frameSize = 800;


    public CheckersGame() {
        frame = new JFrame("Checkers");
        frame.setSize(frameSize, frameSize);
        frame.setVisible(true);
        CheckersBoard board = new CheckersBoard(frameSize);

        frame.add(board);
    }
}
