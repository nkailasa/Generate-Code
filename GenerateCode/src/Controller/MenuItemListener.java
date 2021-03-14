package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.Panels.RightPanel.Canvas;

public class MenuItemListener implements ActionListener {

	/**
	 * Invoked when an action occurs.
	 *
	 * @param e the event to be processed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		switch (action) {
		case "Load":
			break;
		case "Save":
			break;
		case "New Tab":
			Canvas.getInstance().addNewTab();
			break;
		case "Compile":
			break;
		default:
			break;
		}
	}
}
