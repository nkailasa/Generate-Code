package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import Model.Icons.Edge;
import Model.Icons.Graph;
import View.CompileModal;
import View.DragAndDrop.DragAndDropLabel;
import View.Panels.RightPanel.Canvas;

/**
 * This class handles the actions of menu items from the App
 * 
 * @author Nevedita Kailasam
 * @author Amar Yadav
 * @author Rakeen Huq
 * @author Isaac Beale
 */
public class MenuItemListener implements ActionListener {

	private JFrame frame;

	public void setReference(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * This method saves the current tab entries as an encrypted file
	 * 
	 * @author Rakeen Huq
	 */
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
			output.close();
		}
	}

	/**
	 * This method clears the current tab and repaints it with the newly loaded file
	 * data The file has an encrypted connection of nodes and edges that was
	 * previously saved
	 * 
	 * @author Rakeen Huq
	 */
	private void loadIcons() throws IOException, ClassNotFoundException {
		JFileChooser fileChooser = new JFileChooser();
		int selection = fileChooser.showOpenDialog(frame);
		if (selection == JFileChooser.APPROVE_OPTION) {
			File chosenFile = fileChooser.getSelectedFile();
			FileInputStream file = new FileInputStream(chosenFile);
			ObjectInputStream input = new ObjectInputStream(file);

			Graph graphObject = (Graph) input.readObject();
			Canvas.getInstance().tab.removeAll();
			Canvas.getInstance().tab.myLabels = (ArrayList<DragAndDropLabel>) graphObject.getDnDLabels();
			Canvas.getInstance().tab.edges = (ArrayList<Edge>) graphObject.getEdges();

			Canvas.getInstance().tab.revalidate();
			Canvas.getInstance().tab.repaint();
			input.close();
		}

	}

	/**
	 * Invoked when a menu item is being clicked
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
				CompileModal compileModal = new CompileModal();
				compileModal.setCompilationResults(success);
				compileModal.setVisible(true);
				break;
			default:
				break;
			}
		} catch (IOException | ClassNotFoundException ioException) {
			ioException.printStackTrace();
		}
	}
}
