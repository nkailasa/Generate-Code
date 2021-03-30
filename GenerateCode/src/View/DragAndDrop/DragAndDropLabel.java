package View.DragAndDrop;

import Model.Icons.IconParent;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.io.Serial;

/**
 * This class has the structure of icons represented as labels and their
 * input/output buttons. The co-ordinates of location and the restrictions
 * related to the icon are also handled
 * 
 * @author Amar Yadav
 * @author Nevedita Kailasam
 * @author Isaac Beale
 * @author Rakeen Huq
 */
public class DragAndDropLabel extends JLabel {

    @Serial
    private static final long serialVersionUID = 1L;
    private final IconParent iconParent;
    double x;
    double y;
    protected JButton[] inputButtons = new JButton[2];
    protected JButton[] outputButtons = new JButton[2];

    public DragAndDropLabel(IconParent iconParent) {
        super(iconParent.getText(), SwingConstants.CENTER);

        setFont(new Font("Arial", Font.PLAIN, 30));

        setPreferredSize(new Dimension(100, 100));
        CustomBorder customBorder = new CustomBorder(15, x, y);
        setBorder(customBorder);

        this.iconParent = iconParent;
    }

    public void setCoordinates(Point point) {
        this.x = point.x;
        this.y = point.y;
    }

    public void setInputButton(int i, JButton btn) {
        this.inputButtons[i] = btn;
    }

    public void setOutputButton(int i, JButton btn) {
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

    /**
     * This class creates the oval shaped border of icons.
     * 
     * @see // https://stackoverflow.com/questions/17834573/swing-custom-border
     * @see http://www.java2s.com/Code/Java/Swing-JFC/Ovalborder.htm
     * @see http://www.java2s.com/Code/Java/2D-Graphics-GUI/Drawanovaloutline.htm
     * @author Rakeen Huq
     */
    class CustomBorder extends AbstractBorder {
        private final int size;
        private final int x;
        private final int y;

        public CustomBorder(int size, double x, double y) {
            this.size = size;
            this.x = (int) x;
            this.y = (int) y;
        }

        @Override
        public void paintBorder(Component component, Graphics graphics, int x, int y, int width, int height) {
            graphics.setColor(Color.black);
            graphics.drawOval(this.x, this.y, 100, 80);
        }

        @Override
        public Insets getBorderInsets(Component component) {
            return (getBorderInsets(component, new Insets(size, size, size, size)));
        }

        @Override
        public Insets getBorderInsets(Component component, Insets insets) {
            insets.left = insets.top = insets.right = insets.bottom = size;
            return insets;
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }
    }

}