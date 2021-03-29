package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import View.DragAndDrop.AddValueModal;
import View.DragAndDrop.DragAndDropLabel;
import View.Panels.RightPanel.Tab;

/**
 * This class listens to the input and output buttons clicked from the right
 * panel The component associated to the click is recorded to draw the
 * connections
 * 
 * @author Nevedita Kailasam
 */
public class ButtonListener implements MouseListener {
	DragAndDropLabel currButton;
	Tab dropPanel;

	public ButtonListener(Tab panel) {
		dropPanel = panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getClickCount() == 2) {
			AddValueModal modal = new AddValueModal();
			modal.setIcon(currButton);
			modal.setVisible(true);
		} else if((e.getClickCount() == 1)) {
			currButton = (DragAndDropLabel) e.getComponent();
			dropPanel.addCurrButton(currButton);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
