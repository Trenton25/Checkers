import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CheckersBoard extends JPanel implements ActionListener {

    private int pieceSize;
    private ArrayList<CheckerTile> tiles;
    private final int[] blackStartingPos = {1, 3, 5, 7,
                                            8, 10, 12, 14,
                                            17, 19, 21, 23};

    private final int[] redStartingPos = {40, 42, 44, 46,
                                          49, 51, 53, 55,
                                          56, 58, 60, 62};

    private CheckerTile selectedTile;

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
                tiles.add(new CheckerTile(c, pieceSize));
                c = switchColor(c);
            }
            c = switchColor(c);
        }

        for (CheckerTile tile: tiles) {
            tile.addActionListener(this);
            add(tile);
        }

        for (int i = 0; i < blackStartingPos.length; i++) {
            tiles.get(blackStartingPos[i]).setPiece(Color.BLACK);
        }

        for (int i = 0; i < redStartingPos.length; i++) {
            tiles.get(redStartingPos[i]).setPiece(Color.red);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (selectedTile != null) {
            selectedTile.setBackground(Color.BLACK);
        }

        CheckerTile tile = (CheckerTile) e.getSource();

       if (tile.hasPiece()) {
           selectedTile = tile;
           selectedTile.setBackground(Color.lightGray);
        } else {
            moveTile(selectedTile, tile);
            selectedTile = null;
        }
    }

    public void moveTile(CheckerTile selectedTile, CheckerTile destinationTile) {
        if (destinationTile.hasPiece())
            return;

        if (selectedTile != null && isOpenSpaceMove(selectedTile, destinationTile) ) {
            destinationTile.setPiece(selectedTile.getPieceColor());
            selectedTile.removePiece();
        }

        if (selectedTile != null && isJumpMove(selectedTile, destinationTile)) {

        }
    }

    public boolean isJumpMove(CheckerTile selectedTile, CheckerTile destinationTile) {
        int selectedTileIndex = tiles.indexOf(selectedTile);
        Color selectedPieceColor = selectedTile.getPieceColor();
        Color opposingTeamColor = selectedPieceColor == Color.BLACK ? Color.RED : Color.BLACK;

        for (int offset : getValidIndexOffsets(selectedTile.getPieceColor())) {
            if (destinationTile == tiles.get(selectedTileIndex + (2 * offset)) &&
                    tiles.get(selectedTileIndex + offset).hasPiece() &&
                    tiles.get(selectedTileIndex + offset).getPieceColor() == opposingTeamColor)
                return true;
        }
        return false;
    }

    public boolean isOpenSpaceMove(CheckerTile selectedTile, CheckerTile destinationTile) {
        int selectedTileIndex = tiles.indexOf(selectedTile);
        for (int offset : getValidIndexOffsets(selectedTile.getPieceColor())) {
            if (destinationTile == tiles.get(selectedTileIndex + offset))
                return true;
        }
        return false;
    }

    public int[] getValidIndexOffsets(Color selectedPieceColor) {
        int[] validIndexOffsets;
        if (selectedPieceColor == Color.BLACK) {
            validIndexOffsets = new int[] {7, 9};
        } else {
            validIndexOffsets = new int[] {-7, -9};
        }
        return validIndexOffsets;
    }
}
