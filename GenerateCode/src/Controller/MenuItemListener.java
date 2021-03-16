package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import View.CompileModal;
import View.Panels.RightPanel.Canvas;
import View.Panels.RightPanel.Tab;

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
			Compiler compiler = new Compiler();
			Canvas canvas = Canvas.getInstance();
			int activeTabIdx = canvas.getSelectedIndex();
			boolean success = compiler.isCompilationSuccessful(canvas.getTabs().get(activeTabIdx).getLabels());
			CompileModal.getInstance().setCompilationResults(success);
			CompileModal.getInstance().setVisible(true);

			break;
		default:
			break;
		}
	}
}
