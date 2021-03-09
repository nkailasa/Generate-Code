package View.Panels;

import java.awt.GridLayout;
import javax.swing.JPanel;

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

import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;

import javax.swing.*;

public class LeftPanel extends JPanel { // drag source

    // final JPanel iconPanel;

    DragAndDropLabel lparen;
    DragAndDropLabel rparen;
    DragAndDropLabel lessThan;
    DragAndDropLabel greaterThan;
    DragAndDropLabel hyphen;
    DragAndDropLabel pipe;
    DragAndDropLabel at;

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
