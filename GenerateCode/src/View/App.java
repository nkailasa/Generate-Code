package View;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Controller.MenuItemListener;
import View.DragAndDrop.DragAndDropLabel;
import View.DragAndDrop.TransferableShapeInfo;
import View.Panels.LeftPanel;
import View.Panels.RightPanel.Canvas;

/**
 * App launches the Generate Code application. This is a frame containing menu
 * options, a left and right panel
 * 
 * @author Amar Yadav
 * @author Nevedita Kailasam
 * @author Isaac Beale
 * @author Rakeen Huq
 */
public class App extends JFrame implements DragGestureListener {

	public App() {

		final int FRAMEWIDTH = 1200;
		final int FRAMEHEIGHT = 800;

		this.setTitle("Title");
		this.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		this.setLayout(new BorderLayout());

		initializeMenu();
		initializeLeftPanel();
		initializeRightPanel();

		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	private void initializeMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		MenuItemListener menuListener = new MenuItemListener();
		menuListener.setReference(this);
		String[] menuItemNames = { "Load", "Save", "New Tab", "Compile" };
		for (String menuItemName : menuItemNames) {
			JMenuItem menuItem = new JMenuItem(menuItemName);
			menuItem.addActionListener(menuListener);
			menu.add(menuItem);
		}

		mb.add(menu);

		this.setJMenuBar(mb);
		this.add(mb);
		this.add(mb, BorderLayout.NORTH);
	}

	/**
	 * This method sets app as DragGestureListener to capture dragging of the icons
	 * 
	 * @author Amar Yadav
	 */
	private void initializeLeftPanel() {
		LeftPanel leftPanel = new LeftPanel(this);
		this.add(leftPanel, BorderLayout.WEST);
	}

	/**
	 * This method sets app as Canvas as the right panel
	 * 
	 * @author Amar Yadav
	 */
	private void initializeRightPanel() {
		Canvas canvas = Canvas.getInstance();
		this.add(canvas, BorderLayout.CENTER);
	}

	/**
	 * This method recognizes the drag movement, copies the icon that has been
	 * clicked. The copied icon follows the cursor's path to get placed on where it
	 * is being dropped
	 * 
	 * @author Amar Yadav
	 */
	@Override
	public void dragGestureRecognized(DragGestureEvent event) {
		Cursor cursor = Cursor.getDefaultCursor();

		DragAndDropLabel label = (DragAndDropLabel) event.getComponent();

		if (event.getDragAction() == DnDConstants.ACTION_COPY) {
			cursor = DragSource.DefaultCopyDrop;

		} else {
			cursor = DragSource.DefaultCopyNoDrop;
		}

		event.startDrag(cursor, new TransferableShapeInfo(label));

	}

	public static void main(String[] args) {
		new App();
	}
}
