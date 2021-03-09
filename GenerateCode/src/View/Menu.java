package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener {

    static JMenuBar mb;
    static JMenu menu;
    static JMenuItem load, save, newSpace, compile;
    static JLabel label;

    public JMenuBar menuBar() {
        menu = new JMenu("Menu");
        mb = new JMenuBar();

        //create menu items
        load = new JMenuItem("Load");
        save = new JMenuItem("Save");
        newSpace = new JMenuItem("NewSpace");
        compile = new JMenuItem("Compile");

        //add listeners to menu items.
        save.addActionListener(this);
        load.addActionListener(this);
        newSpace.addActionListener(this);
        compile.addActionListener(this);

        //add items to menu
        menu.add(save);
        menu.add(load);
        menu.add(newSpace);
        menu.add(compile);

        mb.add(menu);

        return mb;
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //listener actions go here
    }
}
