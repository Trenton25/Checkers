import javax.swing.*;
import java.awt.*;

public class CheckerTile extends JButton {

    private Color color;

    private ImageIcon image;

    public CheckerTile(Color c) {
        color = c;
        setBackground(color);
        setOpaque(true);
        setBorderPainted(false);
    }

    public Color getColor() {return color;}

    public void setImage(ImageIcon img) {
        image = img;
        setIcon(image);
    }

    public ImageIcon getImage() {
        return image;
    }

    public boolean hasImage() {
        if (image != null) {
            return true;
        }
        return false;
    }

    public void removeImage() {
        image = null;
        setIcon(null);
    }
}
