package View.Panels;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Model.Icons.AtSymbol;
import Model.Icons.DoublePipe;
import Model.Icons.GreaterThan;
import Model.Icons.Hyphen;
import Model.Icons.LParen;
import Model.Icons.LessThan;
import Model.Icons.RParen;
import View.DragAndDrop.DragAndDropLabel;

public class LeftPanel extends JPanel { // drag source
    private static final long serialVersionUID = -1827724962934234619L;

    DragAndDropLabel lparen;
    DragAndDropLabel rparen;
    DragAndDropLabel lessThan;
    DragAndDropLabel greaterThan;
    DragAndDropLabel hyphen;
    DragAndDropLabel pipe;
    DragAndDropLabel at;

    public static DragAndDropLabel getNewLabelFromText(String text) {
        DragAndDropLabel newLabel = null;
        // System.out.println("getNewLabelFromTexttext: [" + text + "]");

        switch (text) {
        case LParen.labelText:
            newLabel = new DragAndDropLabel(new LParen());
            break;
        case RParen.labelText:
            newLabel = new DragAndDropLabel(new RParen());
            break;
        case LessThan.labelText:
            newLabel = new DragAndDropLabel(new LessThan());
            break;
        case GreaterThan.labelText:
            newLabel = new DragAndDropLabel(new GreaterThan());
            break;
        case Hyphen.labelText:
            newLabel = new DragAndDropLabel(new Hyphen());
            break;
        case AtSymbol.labelText:
            newLabel = new DragAndDropLabel(new AtSymbol());
            break;
        case DoublePipe.labelText:
            newLabel = new DragAndDropLabel(new DoublePipe());
            break;
        default:
            System.out.println("DEFAULT!");
        }

        return newLabel;
    }

    public LeftPanel(DragGestureListener dragGestureListener) {
        super(new GridLayout(7, 0, 5, 5));
        setBorder(BorderFactory.createLineBorder(Color.gray));

        DragSource ds;

        ds = new DragSource();
        this.lparen = new DragAndDropLabel(new LParen());
        ds.createDefaultDragGestureRecognizer(this.lparen, DnDConstants.ACTION_COPY, dragGestureListener);

        ds = new DragSource();
        this.rparen = new DragAndDropLabel(new RParen());
        ds.createDefaultDragGestureRecognizer(this.rparen, DnDConstants.ACTION_COPY, dragGestureListener);

        ds = new DragSource();
        this.lessThan = new DragAndDropLabel(new LessThan());
        ds.createDefaultDragGestureRecognizer(this.lessThan, DnDConstants.ACTION_COPY, dragGestureListener);

        ds = new DragSource();
        this.greaterThan = new DragAndDropLabel(new GreaterThan());
        ds.createDefaultDragGestureRecognizer(this.greaterThan, DnDConstants.ACTION_COPY, dragGestureListener);

        ds = new DragSource();
        this.hyphen = new DragAndDropLabel(new Hyphen());
        ds.createDefaultDragGestureRecognizer(this.hyphen, DnDConstants.ACTION_COPY, dragGestureListener);

        ds = new DragSource();
        this.at = new DragAndDropLabel(new AtSymbol());
        ds.createDefaultDragGestureRecognizer(this.at, DnDConstants.ACTION_COPY, dragGestureListener);

        ds = new DragSource();
        this.pipe = new DragAndDropLabel(new DoublePipe());
        ds.createDefaultDragGestureRecognizer(this.pipe, DnDConstants.ACTION_COPY, dragGestureListener);

        this.add(lparen);
        this.add(rparen);
        this.add(lessThan);
        this.add(greaterThan);
        this.add(hyphen);
        this.add(at);
        this.add(pipe);

    }

}
