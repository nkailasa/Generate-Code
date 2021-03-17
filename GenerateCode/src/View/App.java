package View;

import Controller.MenuItemListener;
import View.DragAndDrop.DragAndDropLabel;
import View.DragAndDrop.TransferableShapeInfo;
import View.Panels.LeftPanel;
import View.Panels.RightPanel.Canvas;

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;

public class App extends JFrame implements DragGestureListener {

	final int FRAMEWIDTH = 1200;
	final int FRAMEHEIGHT = 800;

	public App() {

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
		String[] menuItemNames = {"Load", "Save", "New Tab", "Compile"};
		for(String menuItemName : menuItemNames){
			JMenuItem menuItem = new JMenuItem(menuItemName);
			menuItem.addActionListener(menuListener);
			menu.add(menuItem);
		}

		mb.add(menu);

		this.setJMenuBar(mb);
		this.add(mb);
		this.add(mb, BorderLayout.NORTH);
	}

	private void initializeLeftPanel() {
		LeftPanel leftPanel = new LeftPanel(this); // passed as DragGestureListener
		this.add(leftPanel, BorderLayout.WEST);
	}

	private void initializeRightPanel() { // right panel
		Canvas canvas = Canvas.getInstance();
		this.add(canvas, BorderLayout.CENTER);
	}

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


