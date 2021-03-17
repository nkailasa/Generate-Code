package Controller;

import View.Panels.RightPanel.Tab;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;

/**
 * This class sets the drop target-the right panel and pastes the copied
 * draggable icon
 * 
 * @see https://zetcode.com/javaswing/draganddrop/
 * @author Amar Yadav
 */
public class MyDropTargetListener extends DropTargetAdapter {
    private final Tab dropPanel;

    public MyDropTargetListener(Tab panel) {
        dropPanel = panel;
        new DropTarget(panel, DnDConstants.ACTION_COPY, this, true, null);

    }

    @Override
    public void drop(DropTargetDropEvent event) {
        try {

            Transferable tr = event.getTransferable();
            Point point = event.getLocation();
            String labelText = (String) tr.getTransferData(DataFlavor.stringFlavor);

            if (event.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                event.acceptDrop(DnDConstants.ACTION_COPY);
                dropPanel.createAndAddDnDLabel(labelText, point);
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
