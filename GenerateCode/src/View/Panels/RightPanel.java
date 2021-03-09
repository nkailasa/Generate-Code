package View.Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.HeadlessException;
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
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import javax.swing.*;

import View.DragAndDrop.DragAndDropLabel;

public class RightPanel extends JPanel { // drop target

    ArrayList<DragAndDropLabel> myLabels = new ArrayList<>();

    public RightPanel() {
        super();
        setBorder(BorderFactory.createLineBorder(Color.darkGray));
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        for (DragAndDropLabel myLabel : myLabels) { // draw rest components
            Rectangle2D r = myLabel.getRect();
            int x = (int) myLabel.getDroppedAtX();
            int y = (int) myLabel.getDroppedAtY();

            // grphcs.setColor(myLabel.getRectColor());
            // graphics.drawRect((int) r.getX(), (int) r.getY(), (int) r.getWidth(), (int)
            // r.getHeight());
            // graphcs.draw
            add(myLabel);
            myLabel.setLocation(new Point(x, y));
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    public void addDragAndDropLabel(DragAndDropLabel l) {
        myLabels.add(l);
    }
}
