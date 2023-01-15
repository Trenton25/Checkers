import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CheckersBoard extends JPanel implements ActionListener {

    private int pieceSize;
    private ArrayList<CheckerTile> tiles;
    private final int[] blackStartingPos = {0, 2, 4, 6,
            9, 11, 13, 15,
            16, 18, 20, 22};

    private final int[] redStartingPos = {41, 43, 45, 47,
            48, 50, 52, 54,
            57, 59, 61, 63};

    public CheckersBoard(int boardSize) {
        final Main main = new Main();
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                initComponents(main, boardSize);
            }
        });
    }

    private Color switchColor(Color c) {
        if (c == Color.RED) {
            return Color.BLACK;
        }
        return Color.RED;
    }

    private void initComponents(Main main, int frameSize) {
        pieceSize = frameSize/10;
        tiles = new ArrayList<>();

        setSize(frameSize, frameSize);
        setLayout(new GridLayout(8, 8));
        setVisible(true);

        Color c = Color.RED;
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tiles.add(new CheckerTile(c));
                c = switchColor(c);
            }
            c = switchColor(c);
        }

        for (CheckerTile tile: tiles) {
            tile.addActionListener(this);
            add(tile);
        }

        for (int i = 0; i < blackStartingPos.length; i++) {
            ImageIcon img = new ImageIcon("black_piece.png");
            img = resizeImage(img);
            tiles.get(blackStartingPos[i]).setImage(img);
        }

        for (int i = 0; i < redStartingPos.length; i++) {
            ImageIcon img = new ImageIcon("red_piece.png");
            img = resizeImage(img);
            tiles.get(redStartingPos[i]).setImage(img);
        }
    }

    private ImageIcon resizeImage(ImageIcon img) {
        Image image = img.getImage();
        Image newImage = image.getScaledInstance(pieceSize, pieceSize, Image.SCALE_DEFAULT);
        return new ImageIcon(newImage);
    }

    public void actionPerformed(ActionEvent e) {
        CheckerTile tile = (CheckerTile) e.getSource();

        if (tile.hasImage()) {
            tile.removeImage();
        } else {
            ImageIcon img = new ImageIcon("red_piece.png");
            img = resizeImage(img);
            tile.setImage(img);
        }
    }
}
