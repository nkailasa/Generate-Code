package View.Panels.RightPanel;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.GridBagConstraints;  
import java.awt.GridBagLayout;
import java.awt.Insets;

import Controller.MyDropTargetListener;

public class Canvas extends JTabbedPane {

    private static Canvas instance;

    public static Canvas getInstance() {
        if (instance == null) {
            instance = new Canvas();
        }

        return instance;
    }

    // class details
    ArrayList<Tab> tabs;

    private Canvas() {
        tabs = new ArrayList<Tab>();
        addNewTab();
    }

    public ArrayList<Tab> getTabs() {
        return getInstance().tabs;
    }

    public void addNewTab() {
        // System.out.println("Adding new Tab");

        Tab tab = new Tab();
        new MyDropTargetListener(tab);
        tabs.add(tab);
        
        String title = "Tab-" + tabs.size();
        this.add(title, tab);
                

        int index = tabs.size() - 1;
        JPanel pnlTab = new JPanel(new GridBagLayout());
        pnlTab.setPreferredSize(new Dimension(80, 50));
        pnlTab.setOpaque(false);
        JLabel lblTitle = new JLabel(title);
        JButton btnClose = getSmallCloseButton();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;

        pnlTab.add(lblTitle, gbc);

        gbc.gridx++;
        gbc.weightx = 0;
        pnlTab.add(btnClose, gbc);

        this.setTabComponentAt(index, pnlTab);

        btnClose.addActionListener(new MyCloseActionHandler(title, this));

        tab.setVisible(true);

        revalidate();
        repaint();
    }

    public static JButton getSmallCloseButton(){
        JButton button = new JButton("x");
        button.setPreferredSize(new Dimension(5, 30));
        button.setBorder(BorderFactory.createEmptyBorder(2, 8, 2, 8));
        button.setBorderPainted(false); 
        button.setContentAreaFilled(false); 
        button.setFocusPainted(false); 
        button.setOpaque(false);
        return button;
    }

    class MyCloseActionHandler implements ActionListener {

        private String tabName;
        private Canvas canvas;

        public MyCloseActionHandler(String tabName, Canvas canvas) {
            this.tabName = tabName;
            this.canvas = canvas;
        }

        public String getTabName() {
            return tabName;
        }

        public void actionPerformed(ActionEvent evt) {

            int index = canvas.indexOfTab(getTabName());
            if (index >= 0) {

                canvas.removeTabAt(index);
                tabs.remove(index);
                // It would probably be worthwhile getting the source
                // casting it back to a JButton and removing
                // the action handler reference ;)

            }

        }

    }
}
