import javax.swing.*;
import java.awt.*;

public class CheckersGame {

    JFrame frame;

    public CheckersGame() {
        frame = new JFrame("Checkers");
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(0, 8));
        frame.setVisible(true);

        Color c = Color.RED;
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                frame.add(new CheckerTile(c));
            }

            if (c == Color.RED) {
                c = Color.BLACK;
            } else {
                c = Color.RED;
            }
        }
    }
}
