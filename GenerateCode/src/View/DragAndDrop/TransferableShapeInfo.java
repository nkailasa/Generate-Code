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

    protected static DataFlavor CustomFlavour = new DataFlavor(DragAndDropLabel.class, "A DragAndDropLabel object");
    protected static DataFlavor[] supportedFlavors = { CustomFlavour, DataFlavor.stringFlavor };

    private String iconName;
    private DragAndDropLabel myLabel;

    public TransferableShapeInfo(DragAndDropLabel label) {
        this.myLabel = label;
        this.iconName = label.getIconParent().getText();
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
        } else if(flavor.equals(DataFlavor.stringFlavor)){
            return true;
        }
        return false;
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
        if (flavor.equals(CustomFlavour)) {
            System.out.println("Here2: "+myLabel.getIconParent().getText());
            return myLabel;
        } else if (flavor.equals(DataFlavor.stringFlavor)) {
            // return myLabel;
            return myLabel.getIconParent().getText();
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
    }
}
