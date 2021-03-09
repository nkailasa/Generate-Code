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

public class DndExample {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }

            private void createAndShowGUI() {

                final JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                DropPanel dropPanel = new DropPanel();

                Rectangle2D rectangleA = new Rectangle2D.Double(20, 20, 120, 50);
                Rectangle2D rectangleB = new Rectangle2D.Double(60, 90, 120, 50);

                MyLabel label1 = new MyLabel("gray", rectangleA, Color.GRAY);
                MyLabel label2 = new MyLabel("green", rectangleB, Color.GREEN);

                JPanel dp = new JPanel();

                dp.add(label1);
                dp.add(label2);

                JLabel label = new JLabel("Drag text here");
                dropPanel.add(label);

                JSeparator js = new JSeparator(JSeparator.VERTICAL);

                new MyDropTargetListener(dropPanel);

                MyDragGestureListener dlistener = new MyDragGestureListener();

                DragSource ds1 = new DragSource();
                ds1.createDefaultDragGestureRecognizer(label1, DnDConstants.ACTION_COPY, dlistener);

                DragSource ds2 = new DragSource();
                ds2.createDefaultDragGestureRecognizer(label2, DnDConstants.ACTION_COPY, dlistener);

                frame.add(dropPanel, BorderLayout.WEST);
                frame.add(js);
                frame.add(dp, BorderLayout.EAST);

                frame.pack();
                frame.setVisible(true);

            }
        });
    }
}

class MyLabel extends JLabel { //done - label to be transferred

    Rectangle2D rect;
    private final Color color;

    public MyLabel(String text, Rectangle2D rect, Color color) {
        super(text);
        this.rect = rect;
        this.color = color;
    }

    public Rectangle2D getRect() {
        return rect;
    }

    public Color getRectColor() {
        return color;
    }
}

class DropPanel extends JPanel { //done - drop target

    ArrayList<MyLabel> myLabels = new ArrayList<>();

    public DropPanel() {
        super();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);

        for (MyLabel myLabel : myLabels) { //draw rest components
            Rectangle2D r = myLabel.getRect();
            grphcs.setColor(myLabel.getRectColor());
            grphcs.drawRect((int) r.getX(), (int) r.getY(), (int) r.getWidth(), (int) r.getHeight());
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    void addMyLabel(MyLabel l) {
        myLabels.add(l);
    }
}

class MyDropTargetListener extends DropTargetAdapter { //done

    private DropTarget dropTarget;
    private DropPanel dp;

    public MyDropTargetListener(DropPanel panel) {
        dp = panel;
        dropTarget = new DropTarget(panel, DnDConstants.ACTION_COPY, this, true, null);

    }

    @Override
    public void drop(DropTargetDropEvent event) {
        try {
            DropTarget test = (DropTarget) event.getSource();
            Component ca = (Component) test.getComponent();
            Point dropPoint = ca.getMousePosition();
            Transferable tr = event.getTransferable();

            if (event.isDataFlavorSupported(TransferableShapeInfo.CustomFlavour)) {
                MyLabel myLabel = (MyLabel) tr.getTransferData(TransferableShapeInfo.CustomFlavour);

                if (myLabel != null) {
                    dp.addMyLabel(myLabel);
                    dp.revalidate();
                    dp.repaint();

                    event.dropComplete(true);
                }
            } else {
                event.rejectDrop();
            }
        } catch (HeadlessException | UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
            event.rejectDrop();
        }
    }
}

class TransferableShapeInfo implements Transferable { //done

    protected static DataFlavor CustomFlavour = new DataFlavor(MyLabel.class, "A label object");
    protected static DataFlavor[] supportedFlavors = { DataFlavor.stringFlavor, CustomFlavour };
    private String iconName;
    private MyLabel myrectangle;

    public TransferableShapeInfo(MyLabel label) {
        this.myrectangle = label;
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
            return myrectangle;
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
    }
}

class MyDragGestureListener implements DragGestureListener { //done

    Rectangle2D rectangleA = new Rectangle2D.Double(20, 20, 120, 50);
    Rectangle2D rectangleB = new Rectangle2D.Double(60, 90, 120, 50);
    MyLabel grayRect = new MyLabel("gray", rectangleA, Color.GRAY);
    MyLabel greenRect = new MyLabel("green", rectangleB, Color.GREEN);
    private MyLabel rectangleToDrag;

    @Override
    public void dragGestureRecognized(DragGestureEvent event) {
        Cursor cursor = null;

        MyLabel label = (MyLabel) event.getComponent();
        String text = label.getText();

        if (text.equals("gray")) {
            rectangleToDrag = grayRect;
        }
        if (text.equals("green")) {
            rectangleToDrag = greenRect;
        }

        if (event.getDragAction() == DnDConstants.ACTION_COPY) {
            cursor = DragSource.DefaultCopyDrop;

        } else {
            cursor = DragSource.DefaultCopyNoDrop;
        }

        event.startDrag(cursor, new TransferableShapeInfo(rectangleToDrag));

    }
}