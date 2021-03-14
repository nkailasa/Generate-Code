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
import Controller.MyDropTargetListener;
import View.DragAndDrop.DragAndDropLabel;
import View.DragAndDrop.TransferableShapeInfo;
import View.Panels.LeftPanel;
import View.Panels.RightPanel.Canvas;
import View.Panels.RightPanel.Tab;

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
		JMenuBar mb;
		JMenu menu;
		JMenuItem load, save, newSpace, compile;

		menu = new JMenu("Menu");
		mb = new JMenuBar();

		// create menu items
		load = new JMenuItem("Load");
		save = new JMenuItem("Save");
		newSpace = new JMenuItem("New Tab");
		compile = new JMenuItem("Compile");

		menu.add(save);
		menu.add(load);
		menu.add(newSpace);
		menu.add(compile);

		MenuItemListener menulistener = new MenuItemListener();
		save.addActionListener(menulistener);
		load.addActionListener(menulistener);
		newSpace.addActionListener(menulistener);
		compile.addActionListener(menulistener);

		mb.add(menu);

		this.setJMenuBar(mb);
		this.add(mb, BorderLayout.NORTH);
		// this.add(mb, BorderLayout.NORTH);

	}

	private void initializeLeftPanel() {
		LeftPanel leftPanel = new LeftPanel(this); // passed as DragGestureListener
		this.add(leftPanel, BorderLayout.WEST);
	}

	private void initializeRightPanel() { // right panel
		Canvas canvas = Canvas.getInstance();
		// Tab tab = new Tab();
		// new MyDropTargetListener(tab);
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

}