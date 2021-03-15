package Controller;


import Model.Icons.Graph;
import View.CompileModal;
import View.Panels.RightPanel.Canvas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class MenuItemListener implements ActionListener {

	private JFrame frame;

	public void setReference(JFrame frame) {
		this.frame = frame;
	}


	private void saveIcons() throws IOException {
		Graph graphInstance = Graph.getInstance();

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Choose where to save your file");
		int selection = fileChooser.showSaveDialog(frame);
		if (selection == JFileChooser.APPROVE_OPTION) {
			File chosenFile = fileChooser.getSelectedFile();
			FileOutputStream file = new FileOutputStream(chosenFile);
			ObjectOutputStream output = new ObjectOutputStream(file);
			output.writeObject(graphInstance);
		}
	}

	private void loadIcons() throws IOException, ClassNotFoundException {
		Graph graphInstance = Graph.getInstance();
		JFileChooser fileChooser = new JFileChooser();
		int selection = fileChooser.showOpenDialog(frame);
		if (selection == JFileChooser.APPROVE_OPTION) {
			File chosenFile = fileChooser.getSelectedFile();
			FileInputStream file = new FileInputStream(chosenFile);
			ObjectInputStream input = new ObjectInputStream(file);

			Graph graphObject = (Graph) input.readObject();
			System.out.println(graphObject.getEdges().size());
			System.out.println(graphObject.getDnDLabels().size());

			graphInstance.setDnDLabels(graphObject.getDnDLabels());
			graphInstance.setEdges(graphObject.getEdges());

			frame.revalidate();
			frame.repaint();
		}

	}

	/**
	 * Invoked when an action occurs.
	 *
	 * @param e the event to be processed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		try {
			switch (action) {
				case "Load":
					loadIcons();
					break;
				case "Save":
					saveIcons();
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
		} catch (IOException | ClassNotFoundException ioException) {
			ioException.printStackTrace();
		}
	}
}
