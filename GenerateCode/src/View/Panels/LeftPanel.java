package View.Panels;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import View.DragAndDrop.DragAndDropLabel;
import View.Icons.AtSymbol;
import View.Icons.DoublePipe;
import View.Icons.GreaterThan;
import View.Icons.Hyphen;
import View.Icons.LParen;
import View.Icons.LessThan;
import View.Icons.RParen;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;

import javax.swing.*;

public class LeftPanel extends JPanel { // drag source

    // final JPanel iconPanel;

    /**
     *
     */
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
        System.out.println("getNewLabelFromTexttext: [" + text + "]");

        switch (text) {
        case " ( .":
            newLabel = new DragAndDropLabel(new LParen());
            break;
        case ". ) ":
            newLabel = new DragAndDropLabel(new RParen());
            break;
        case ".  <  :":
            newLabel = new DragAndDropLabel(new LessThan());
            break;
        case ":  >  .":
            newLabel = new DragAndDropLabel(new GreaterThan());
            break;
        case ".  --  .":
            newLabel = new DragAndDropLabel(new Hyphen());
            break;
        case "  @  ":
            newLabel = new DragAndDropLabel(new AtSymbol());
            break;
        case "*  |  |  *":
            newLabel = new DragAndDropLabel(new DoublePipe());
            break;
        default:
            System.out.println("DEFAULT!");
        }

        System.out.println("getNewLabelFromTexttext2: " + newLabel.getIconParent().getText());
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
