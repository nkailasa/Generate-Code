package View.Panels;

import Model.Icons.*;
import View.DragAndDrop.DragAndDropLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.io.Serial;
import java.util.ArrayList;

/**
 * This is the container of all icons that can be dragged
 * 
 * @author Amar Yadav
 * @author Nevedita Kailasam
 * @author Isaac Beale
 */
public class LeftPanel extends JPanel { // drag source
	@Serial
	private static final long serialVersionUID = 1L;

	public LeftPanel(DragGestureListener dragGestureListener) {
		super(new GridLayout(7, 0, 5, 5));
		setBorder(BorderFactory.createLineBorder(Color.gray));

		DragSource ds = new DragSource();
		ArrayList<DragAndDropLabel> labels = new ArrayList<DragAndDropLabel>();
		labels.add(new DragAndDropLabel(new LessThan()));
		labels.add(new DragAndDropLabel(new GreaterThan()));
		labels.add(new DragAndDropLabel(new Hyphen()));
		labels.add(new DragAndDropLabel(new AtSymbol()));
		labels.add(new DragAndDropLabel(new LPipe()));
		labels.add(new DragAndDropLabel(new RPipe()));
		for (DragAndDropLabel label : labels) {
			ds.createDefaultDragGestureRecognizer(label, DnDConstants.ACTION_COPY, dragGestureListener);
			this.add(label);
		}

	}

	/**
	 * This method creates the structure for the icon before placing it on the right
	 * panel an icon will have specific input and output buttons, its label and
	 * group them as a panel
	 * 
	 * @return p - a panel with all input and output buttons *
	 */
	public static JPanel getNewLabelFromText(String text) {
		DragAndDropLabel newLabel = new DragAndDropLabel(new LessThan());
		JPanel panel = new JPanel();

		switch (text) {
		case Constants.LPAREN:
			newLabel = new DragAndDropLabel(new LParen());
			break;
		case Constants.RPAREN:
			newLabel = new DragAndDropLabel(new RParen());
			break;
		case Constants.LESS_THAN:
			newLabel = new DragAndDropLabel(new LessThan());
			break;
		case Constants.GREATER_THAN:
			newLabel = new DragAndDropLabel(new GreaterThan());
			break;
		case Constants.HYPEN:
			newLabel = new DragAndDropLabel(new Hyphen());
			break;
		case Constants.AT:
			newLabel = new DragAndDropLabel(new AtSymbol());
			break;
		case Constants.LPIPE:
			newLabel = new DragAndDropLabel(new LPipe());
			break;
		case Constants.RPIPE:
			newLabel = new DragAndDropLabel(new RPipe());
			break;
		default:
			break;
		}
		panel.add(newLabel);
		return panel;
	}

}
