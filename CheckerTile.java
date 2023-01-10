import javax.swing.*;
import java.awt.*;

public class CheckerTile extends JButton {

    private Color color;

    private ImageIcon image;

    public CheckerTile(Color c) {
        color = c;
        setBackground(color);
    }

    public Color getColor() {return color;}

    public void setImg(ImageIcon img) {
        image = img;
        setIcon(image);
    }
}
