package Controller;

import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;

import View.Panels.RightPanel.Tab;

public class MyDropTargetListener extends DropTargetAdapter {
    private final DropTarget dropTarget;
    private final Tab dropPanel;

    public MyDropTargetListener(Tab panel) {
        dropPanel = panel;
        dropTarget = new DropTarget(panel, DnDConstants.ACTION_COPY, this, true, null);

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
