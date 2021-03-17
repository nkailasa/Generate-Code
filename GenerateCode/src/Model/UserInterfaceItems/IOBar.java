package Model.UserInterfaceItems;

import java.awt.Dimension;

import javax.swing.JButton;

/**
 * This class sets the features of an input/output bar - which is the
 * representation of a button that accepts several inputs/outputs
 * 
 * @author Isaac Beale
 */
public class IOBar extends JButton {
    private static final long serialVersionUID = 1L;

    public IOBar() {
        setPreferredSize(new Dimension(10, 20));
    }
}
