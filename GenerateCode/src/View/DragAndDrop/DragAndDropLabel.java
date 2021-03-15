package View.DragAndDrop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import Model.Icons.IconParent;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

public class DragAndDropLabel extends JLabel {

    private static final long serialVersionUID = 4524289488932470569L;
    private IconParent iconParent;
    double x;
    double y;
    Rectangle2D rect = new Rectangle2D.Double(60, 90, 120, 50);
    protected JButton[] inputButtons = new JButton[2];
    protected JButton[] outputButtons= new JButton[2];
    
    
    public DragAndDropLabel(IconParent iconParent) {
        super(iconParent.getText(), SwingConstants.CENTER);
        setFont(new Font("Arial", Font.PLAIN, 30));

        setOpaque(true);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(120, 50));

        Border border = getBorder();
        Border margin = new EmptyBorder(10, 10, 10, 10);
        setBorder(new CompoundBorder(border, margin));

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
    
    public void setInputButton(int i,JButton btn) {
        this.inputButtons[i] = btn;
    }
    
    public void setOutputButton(int i,JButton btn) {
        this.outputButtons[i] = btn;
    }
    
    public JButton[] getInputButtons() {
       return this.inputButtons;
    }
    
    public JButton[] getOutputButtons() {
        return this.outputButtons;
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
