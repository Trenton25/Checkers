import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CheckersGame {

    JFrame frame;
    ArrayList<CheckerTile> tiles;

    public CheckersGame() {
        final Main main = new Main();
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                initComponents(main);
            }
        });
    }

    private Color switchColor(Color c) {
        if (c == Color.RED) {
            return Color.BLACK;
        }
        return Color.RED;
    }

    private void initComponents(Main main) {
        tiles = new ArrayList<>();

        frame = new JFrame("Checkers");
        frame.setSize(1000, 1000);
        frame.setLayout(new GridLayout(8, 8));
        frame.setVisible(true);

        Color c = Color.RED;
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tiles.add(new CheckerTile(c));
                c = switchColor(c);
            }
            c = switchColor(c);
        }

        ImageIcon img = new ImageIcon("black_piece.jpg");
        tiles.get(0).setIcon(img);

        for (CheckerTile tile: tiles) {
            frame.add(tile);
        }
    }
}
