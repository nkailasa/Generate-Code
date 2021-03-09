package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;

import javax.swing.*;

import View.DragAndDrop.DragAndDropLabel;
import View.DragAndDrop.MyDropTargetListener;
import View.DragAndDrop.TransferableShapeInfo;
import View.Menu.FileMenu;
import View.Panels.LeftPanel;
import View.Panels.RightPanel;

/**
 * The Game class initializes Game screen along with a grid of buttons in the
 * play area and control buttons like start, pause etc.,
 */
public class App extends JFrame implements DragGestureListener {

	final int FRAMESIZE = 700;

	public App() {

		this.setTitle("Title");
		this.setSize(FRAMESIZE, FRAMESIZE - 100);
		this.setLayout(new BorderLayout());

		initMenubar();
		initializeLeftPanel();
		initializeRightPanel();

		// initMenubar();
		// initializeButtonPanel();
		// initializeCanvas();

		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	private void initMenubar() {
		FileMenu fileMenu = new FileMenu();
		JMenuBar mb = fileMenu.menuBar();
		this.setJMenuBar(mb);
	}

	private void initializeLeftPanel() {
		LeftPanel leftPanel = new LeftPanel(this); //passed as DragGestureListener
		this.add(leftPanel, BorderLayout.WEST);
	}

	private void initializeRightPanel() { // right panel
		RightPanel rightPanel = new RightPanel();
		new MyDropTargetListener(rightPanel);
		this.add(rightPanel, BorderLayout.CENTER);
	}

	private void initializeCanvas() { // right panel
		Container grid = new Container();
		JPanel canvas = new JPanel();
		canvas.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		this.add(canvas, BorderLayout.CENTER);
	}

	private void initializeButtonPanel() { // left panel

		JButton lparen;
		JButton rparen;
		JButton langular;
		JButton rangular;
		JButton hypen;
		JButton pipe;
		JButton at;

		JPanel buttonPanel = new JPanel(new GridLayout(7, 0, 5, 5));
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
		lparen = new JButton(" ( .");
		lparen.setFont(new Font("Arial", Font.PLAIN, 30));

		rparen = new JButton(". ) ");
		lparen.setFont(new Font("Arial", Font.PLAIN, 30));

		langular = new JButton(".  <  :");
		langular.setFont(new Font("Arial", Font.PLAIN, 30));

		rangular = new JButton(":  >  .");
		rangular.setFont(new Font("Arial", Font.PLAIN, 30));

		hypen = new JButton(".  --  .");
		hypen.setFont(new Font("Arial", Font.PLAIN, 30));

		at = new JButton("  @  ");
		at.setFont(new Font("Arial", Font.PLAIN, 30));

		pipe = new JButton("*  |  |  *");
		pipe.setFont(new Font("Arial", Font.PLAIN, 30));

		buttonPanel.add(lparen);
		buttonPanel.add(rparen);
		buttonPanel.add(langular);
		buttonPanel.add(rangular);
		buttonPanel.add(hypen);
		buttonPanel.add(pipe);
		buttonPanel.add(at);

		this.add(buttonPanel, BorderLayout.WEST);
	}

	@Override
	public void dragGestureRecognized(DragGestureEvent event) {
		Cursor cursor = Cursor.getDefaultCursor();

		DragAndDropLabel label = (DragAndDropLabel) event.getComponent();
		// String text = label.getText();

		// if (text.equals("gray")) {
		// rectangleToDrag = grayRect;
		// }
		// if (text.equals("green")) {
		// rectangleToDrag = greenRect;
		// }

		if (event.getDragAction() == DnDConstants.ACTION_COPY) {
			cursor = DragSource.DefaultCopyDrop;

		} else {
			cursor = DragSource.DefaultCopyNoDrop;
		}

		event.startDrag(cursor, new TransferableShapeInfo(label));

	}

}