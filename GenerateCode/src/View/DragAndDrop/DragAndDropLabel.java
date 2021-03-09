package View.DragAndDrop;

import javax.swing.JPanel;

import View.Icons.IconParent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.geom.Rectangle2D;
import java.awt.Font;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;

import java.io.IOException;

public class DragAndDropLabel extends JLabel {

    /**
     *
     */
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

    // public String toString(){

    // }

}
