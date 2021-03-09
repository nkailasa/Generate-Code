package View.DragAndDrop;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

public class TransferableShapeInfo implements Transferable {

    protected static DataFlavor CustomFlavour = new DataFlavor(DragAndDropLabel.class, "A DragAndDropLabel object");
    protected static DataFlavor[] supportedFlavors = { CustomFlavour, DataFlavor.stringFlavor };

    private String iconName;
    private DragAndDropLabel myLabel;

    public TransferableShapeInfo(DragAndDropLabel label) {
        this.myLabel = label;
        this.iconName = label.getIconParent().getText();
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
            return myLabel;
        } else if (flavor.equals(DataFlavor.stringFlavor)) {
            return myLabel.getIconParent().getText();
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
    }
}
