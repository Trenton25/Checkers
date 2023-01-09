import javax.swing.*;
import java.awt.*;

public class CheckerTile extends JPanel {

    private Color color;
    private static boolean isRed = false;

    public CheckerTile(Color startColor) {
        if (startColor == Color.BLACK) {
            isRed = true;
        }

        if (isRed) {
            color = Color.BLACK;
            isRed = false;
        } else {
            color = Color.RED;
            isRed = true;
        }

        setBackground(color);
    }
}
