package View.DragAndDrop;

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

import View.Panels.LeftPanel;
import View.Panels.RightPanel;

public class MyDropTargetListener extends DropTargetAdapter {
    private final DropTarget dropTarget;
    private final RightPanel dropPanel;

    public MyDropTargetListener(RightPanel panel) {
        dropPanel = panel;
        dropTarget = new DropTarget(panel, DnDConstants.ACTION_COPY, this, true, null);

    }

    @Override
    public void drop(DropTargetDropEvent event) {
        try {

            Transferable tr = event.getTransferable();
            Point point = event.getLocation();
            // System.out.println("Here1: "+tr.getTransferData(DataFlavor.stringFlavor));
            String labelText = (String) tr.getTransferData(DataFlavor.stringFlavor);
            // DragAndDropLabel label = (DragAndDropLabel)
            // tr.getTransferData(DataFlavor.stringFlavor);

            DragAndDropLabel label = LeftPanel.getNewLabelFromText(labelText);
            label.setCoordinates(point);
            System.out.println("label: " + label.getIconParent().getText());

            if (event.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                System.out.println("isDataFlavorSupported: true");
                event.acceptDrop(DnDConstants.ACTION_COPY);
                dropPanel.addDragAndDropLabel(label);
                dropPanel.revalidate();
                dropPanel.repaint();
                event.dropComplete(true);
            } else {
                event.rejectDrop();
            }

        } catch (Exception e) {

            e.printStackTrace();
            event.rejectDrop();
        }
    }

}
