package View.DragAndDrop;

import Model.Icons.IconParent;

import javax.swing.JLabel;

import java.awt.geom.Rectangle2D;
import java.awt.Font;
import java.awt.Point;

public class DragAndDropLabel extends JLabel {

    private static final long serialVersionUID = 4524289488932470569L;
    private IconParent iconParent;
    double x;
    double y;
    Rectangle2D rect = new Rectangle2D.Double(60, 90, 120, 50);

    public DragAndDropLabel(IconParent iconParent) {
        super(iconParent.getText());
        setFont(new Font("Arial", Font.PLAIN, 30));

        this.iconParent = iconParent;
    }

    public void setCoordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setCoordinates(Point point) {
        this.x = point.x;
        this.y = point.y;
    }

    public double getDroppedAtX() {
        return this.x;
    }

    public double getDroppedAtY() {
        return this.y;
    }

    public IconParent getIconParent() {
        return this.iconParent;
    }

    public Rectangle2D getRect() {
        return rect;
    }

}
