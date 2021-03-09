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
import View.Panels.RightPanel;

public class App extends JFrame implements DragGestureListener {

	final int FRAMESIZE = 700;

	public App() {

		this.setTitle("Title");
		this.setSize(FRAMESIZE, FRAMESIZE - 100);
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
		newSpace = new JMenuItem("NewSpace");
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
		this.add(mb);

	}

	private void initializeLeftPanel() {
		LeftPanel leftPanel = new LeftPanel(this); // passed as DragGestureListener
		this.add(leftPanel, BorderLayout.WEST);
	}

	private void initializeRightPanel() { // right panel
		RightPanel rightPanel = new RightPanel();
		new MyDropTargetListener(rightPanel);
		this.add(rightPanel, BorderLayout.CENTER);
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