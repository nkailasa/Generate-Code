package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import View.Controller.MenuItemListener;

/**
 * The App class initializes App screen along with a group of buttons in the
 * left pane area.
 */
public class App extends JFrame {

	public App() {

		final int FRAMESIZE = 700;
		this.setTitle("Generate Code");
		this.setSize(FRAMESIZE, FRAMESIZE - 100);
		this.setLayout(new BorderLayout());

		initializeCanvas();
		initializeButtonPanel();
		initializeMenu();

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
		this.add(mb, BorderLayout.NORTH);

	}

	private void initializeCanvas() {

		JPanel canvas = new JPanel();
		canvas.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		this.add(canvas, BorderLayout.CENTER);

	}

	private void initializeButtonPanel() {

		JButton lparen;
		JButton rparen;
		JButton langular;
		JButton rangular;
		JButton hypen;
		JButton pipe;
		JButton at;

		JPanel buttonPanel = new JPanel(new GridLayout(7, 0, 5, 5));
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
		Font bigfont = new Font("Arial", Font.PLAIN, 30);
		lparen = new JButton(" ( .");
		lparen.setFont(bigfont);

		rparen = new JButton(". ) ");
		lparen.setFont(bigfont);

		langular = new JButton(".  <  :");
		langular.setFont(bigfont);

		rangular = new JButton(":  >  .");
		rangular.setFont(bigfont);

		hypen = new JButton(".  --  .");
		hypen.setFont(bigfont);

		at = new JButton("  @  ");
		at.setFont(bigfont);

		pipe = new JButton("*  |  |  *");
		pipe.setFont(bigfont);

		buttonPanel.add(lparen);
		buttonPanel.add(rparen);
		buttonPanel.add(langular);
		buttonPanel.add(rangular);
		buttonPanel.add(hypen);
		buttonPanel.add(pipe);
		buttonPanel.add(at);

		this.add(buttonPanel, BorderLayout.WEST);
	}

}