package Controller;

import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.MouseListener;

import View.DragAndDrop.AddValueModal;
import View.DragAndDrop.DragAndDropLabel;
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
            String labelText = (String) tr.getTransferData(DataFlavor.stringFlavor);

            DragAndDropLabel label = LeftPanel.getNewLabelFromText(labelText);
            label.setCoordinates(point);
            label.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent mouseEvent) {
                    if (mouseEvent.getClickCount() == 2) {
                        AddValueModal modal = AddValueModal.getInstance();
                        modal.setIcon(label);
                        modal.setInputText(label.getIconParent().getValue());
                        modal.setVisible(true);
                    }
                  }
            });

            if (event.isDataFlavorSupported(DataFlavor.stringFlavor)) {
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
