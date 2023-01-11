import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CheckersGame {

    private JFrame frame;
    private final int frameWidth = 1000;
    private final int frameHeight = 1000;

    private final int pieceSize = 100;
    private ArrayList<CheckerTile> tiles;
    private final int[] blackStartingPos = {0, 2, 4, 6,
                                            9, 11, 13, 15,
                                            16, 18, 20, 22};

    private final int[] redStartingPos = {41, 43, 45, 47,
                                            48, 50, 52, 54,
                                            57, 59, 61, 63};

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
        frame.setSize(frameWidth, frameHeight);
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

        for (CheckerTile tile: tiles) {
            frame.add(tile);
        }

        for (int i = 0; i < blackStartingPos.length; i++) {
            ImageIcon imgIcon = new ImageIcon("black_piece.png");
            Image image = imgIcon.getImage();
            Image newImage = image.getScaledInstance(pieceSize, pieceSize, Image.SCALE_DEFAULT);
            imgIcon = new ImageIcon(newImage);

            tiles.get(blackStartingPos[i]).setIcon(imgIcon);
        }

        for (int i = 0; i < redStartingPos.length; i++) {
            ImageIcon imgIcon = new ImageIcon("red_piece.png");
            Image image = imgIcon.getImage();
            Image newImage = image.getScaledInstance(pieceSize, pieceSize, Image.SCALE_DEFAULT);
            imgIcon = new ImageIcon(newImage);

            tiles.get(redStartingPos[i]).setIcon(imgIcon);
        }
    }
}
