package Controller;

import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
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
            String labelText = (String) tr.getTransferData(DataFlavor.stringFlavor);

            // DragAndDropLabel label = LeftPanel.getNewLabelFromText(labelText);
            // label.setCoordinates(point);

            if (event.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                event.acceptDrop(DnDConstants.ACTION_COPY);
                // dropPanel.addDragAndDropLabel(label);
                dropPanel.createAndAddDnDLabel(labelText, point);
                // dropPanel.revalidate();
                // dropPanel.repaint();
                // dropPanel.revalidate();
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
