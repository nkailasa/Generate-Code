package View.DragAndDrop;

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

public class TransferableShapeInfo implements Transferable {

    protected static DataFlavor CustomFlavour = new DataFlavor(DragAndDropLabel.class, "A label object");
    protected static DataFlavor[] supportedFlavors = { DataFlavor.stringFlavor, CustomFlavour };

    private String iconName;
    private DragAndDropLabel myLabel;

    public TransferableShapeInfo(DragAndDropLabel label) {
        this.myLabel = label;
        this.iconName = label.getIconParent().getText();
        // TODO this.iconName = label.iconName; should display custom icon names for
        // each type of symbol
    }

    public TransferableShapeInfo(String text) {
        this.iconName = text;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return supportedFlavors;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        if (flavor.equals(CustomFlavour)) {
            return true;
        }
        return false;
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
        if (flavor.equals(CustomFlavour)) {
            return myLabel;
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
    }
}
