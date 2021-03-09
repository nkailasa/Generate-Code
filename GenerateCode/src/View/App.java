package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import View.Menu.FileMenu;

/**
 * The Game class initializes Game screen along with a grid of buttons in the
 * play area and control buttons like start, pause etc.,
 */
public class App extends JFrame {

	final int FRAMESIZE = 700;

	public App() {

		this.setTitle("Title");
		this.setSize(FRAMESIZE, FRAMESIZE-100);
		this.setLayout(new BorderLayout());

		initializeButtonPanel();
		initializeCanvas();

		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	private void initializeCanvas() {
		Container grid = new Container();
		JPanel canvas = new JPanel();
		canvas.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		this.add(canvas, BorderLayout.CENTER);

		FileMenu fileMenu = new FileMenu();
		JMenuBar mb = fileMenu.menuBar();
		this.setJMenuBar(mb);
	}

	private void initializeButtonPanel() {

		JButton lparen;
		JButton rparen;
		JButton langular;
		JButton rangular;
		JButton hypen;
		JButton pipe;
		JButton at;

		JPanel buttonPanel = new JPanel(new GridLayout(7, 0,5,5));
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

}