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
            DragAndDropLabel label = (DragAndDropLabel) tr.getTransferData(TransferableShapeInfo.CustomFlavour);

            if (event.isDataFlavorSupported(TransferableShapeInfo.CustomFlavour)) {

                event.acceptDrop(DnDConstants.ACTION_COPY);
                dropPanel.addDragAndDropLabel(label);
                dropPanel.revalidate();
                dropPanel.repaint();
                event.dropComplete(true);
                return;
            }

            event.rejectDrop();
        } catch (Exception e) {

            e.printStackTrace();
            event.rejectDrop();
        }
    }

    /*
     *
     * @Override public void drop(DropTargetDropEvent event) { try { DropTarget test
     * = (DropTarget) event.getSource(); Component ca = (Component)
     * test.getComponent(); Point dropPoint = ca.getMousePosition(); Transferable tr
     * = event.getTransferable();
     * 
     * if (event.isDataFlavorSupported(TransferableShapeInfo.CustomFlavour)) {
     * DragAndDropLabel myLabel = (DragAndDropLabel)
     * tr.getTransferData(TransferableShapeInfo.CustomFlavour);
     * 
     * if (myLabel != null) { myLabel.setCoordinates(dropPoint.getX(),
     * dropPoint.getY()); dropPanel.addDragAndDropLabel(myLabel);
     * dropPanel.revalidate(); dropPanel.repaint();
     * 
     * event.dropComplete(true); } } else { event.rejectDrop(); } } catch
     * (HeadlessException | UnsupportedFlavorException | IOException e) {
     * e.printStackTrace(); event.rejectDrop(); } }
     */
}
