package View.Panels.RightPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Arc2D;
import java.io.Serial;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.ButtonListener;
import Model.Icons.Constants;
import Model.Icons.Edge;
import Model.Icons.Graph;
import Model.Icons.IconParent;
import View.DragAndDrop.DragAndDropLabel;
import View.Panels.LeftPanel;

/**
 * Tab is a part of Canvas and contains the logic to implement connections
 * between icons in the right panel. All instances of this class are created
 * in Canvas which serve as DropTargets for icons.
 * 
 * @author Amar Yadav
 * @author Nevedita Kailasam
 * @author Isaac Beale
 * @author Rakeen Huq
 */
public class Tab extends JPanel {
	@Serial
	private static final long serialVersionUID = 1L;
	DragAndDropLabel currLabel, prevLabel;
	public ArrayList<DragAndDropLabel> myLabels = new ArrayList<>();
	public ArrayList<Edge> edges = new ArrayList<Edge>();

	public Tab() {
		super();
		setBorder(BorderFactory.createLineBorder(Color.darkGray));
		createAndAddDnDLabel(Constants.LPAREN, new Point(30, 30));
		createAndAddDnDLabel(Constants.RPAREN, new Point(950, 450));
	}

	/**
	 * The method to repaint screen when another method requests a revalidate the
	 * current tab
	 * 
	 * @author Amar Yadav
	 * @author Nevedita Kailasam
	 * @author Isaac Beale
	 * @author Rakeen Huq
	 */
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		for (DragAndDropLabel myLabel : myLabels) { // draw rest components
			int x = (int) myLabel.getDroppedAtX();
			int y = (int) myLabel.getDroppedAtY();

			JButton[] ipButtons = myLabel.getInputButtons();
			JButton[] opButtons = myLabel.getOutputButtons();
			int xincr = 10;
			int yincr = 10;
			for (JButton btn : ipButtons) {
				if (btn != null) {
					btn.setLocation(new Point(x + xincr, y + yincr));
					btn.setBackground(Color.blue);
					yincr += 20;
					btn.setVisible(true);
					btn.paint(graphics);
					this.add(btn);
				}
			}
			xincr = 100;
			yincr = 10;
			for (JButton btn : opButtons) {
				if (btn != null) {
					btn.setLocation(new Point(x + xincr, y + yincr));
					btn.setBackground(Color.red);
					yincr += 20;
					btn.setVisible(true);

					btn.paint(graphics);
					this.add(btn);
				}
			}
			myLabel.setLocation(new Point(x, y));
			myLabel.setVisible(true);
			myLabel.paint(graphics);
			this.add(myLabel);

		}

		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics;
		g.setPaint(Color.BLUE);
		for (Edge e : edges) {
			int srcX = e.src.getLocation().x + 50;
			int srcY = e.src.getLocation().y + 40;
			int destX = e.dest.getLocation().x + 50;
			int destY = e.dest.getLocation().y + 40;

			if (srcX == destX && srcY == destY) {
				double w = 100;
				double h = 100;
				double start = 200.0;
				double extent = 300.0;
				Arc2D arc = new Arc2D.Double(srcX + 40, srcY - 40, w, h, start, extent, Arc2D.OPEN);
				g.draw(arc);
			} else {
				g.drawLine(srcX, srcY, destX, destY);
				double[] arrow = arrHead(srcX, srcY, destX, destY);
				g.draw(new Line2D.Double(destX, destY, arrow[0], arrow[1]));
				g.draw(new Line2D.Double(destX, destY, arrow[2], arrow[3]));
			}

		}
	}

	/**
	 * The method draws the arrow head to represent the direction of connections
	 * 
	 * @param x1,y1,x2,y2 - the co-ordinates of the destination icon
	 * @return arrHead - the array of co-ordinates to draw the arrowhead
	 * @see https://stackoverflow.com/questions/59905526/problem-when-drawing-arrows-how-do-i-set-the-coordinates-correctly
	 * @author Nevedita Kailasam
	 */
	private double[] arrHead(double x1, double y1, double x2, double y2) {
		double c, a, beta, theta, phi;
		double ax1, ay1, ax2, ay2;
		double len = 25;
		double angle = Math.PI / 10;
		c = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
		if (Math.abs(x2 - x1) < 1e-6)
			if (y2 < y1)
				theta = Math.PI / 2;
			else
				theta = -Math.PI / 2;
		else {
			if (x2 > x1)
				theta = Math.atan((y1 - y2) / (x2 - x1));
			else
				theta = Math.atan((y1 - y2) / (x1 - x2));
		}
		a = Math.sqrt(len * len + c * c - 2 * len * c * Math.cos(angle));
		beta = Math.asin(len * Math.sin(angle) / a);
		phi = theta - beta;
		ay1 = y1 - a * Math.sin(phi); 
		if (x2 > x1)
			ax1 = x1 + a * Math.cos(phi);
		else
			ax1 = x1 - a * Math.cos(phi);
		phi = theta + beta;
		ay2 = y1 - a * Math.sin(phi);
		if (x2 > x1)
			ax2 = x1 + a * Math.cos(phi);
		else
			ax2 = x1 - a * Math.cos(phi);
		double[] arrHead = new double[4];
		arrHead[0] = ax1;
		arrHead[1] = ay1;
		arrHead[2] = ax2;
		arrHead[3] = ay2;
		return arrHead;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(200, 200);
	}

	/**
	 * The method creates a label with buttons when the drop is targeted at a point
	 * in the right panel
	 * 
	 * @param {String} labelText- the icon name
	 * @param {Point}  p- the co-ordinates of the dropped icon
	 * @author Nevedita Kailasam
	 * @author Amar Yadav
	 */
	public void createAndAddDnDLabel(String labelText, Point p) {
		JPanel label = LeftPanel.getNewLabelFromText(labelText);
		DragAndDropLabel lbl = null;

		Component[] components = label.getComponents();
		for (int i = 0; i < components.length; i++) {
			if (components[i] instanceof DragAndDropLabel) {
				lbl = (DragAndDropLabel) components[i];
			}
		}
		DragAndDropLabel dndLabel = lbl;
		dndLabel.setCoordinates(p);
		dndLabel.addMouseListener(new ButtonListener(this));

		myLabels.add(dndLabel);
		dndLabel.setLocation(p);
		dndLabel.setVisible(true);
		this.add(dndLabel);

		JButton[] ipButtons = dndLabel.getInputButtons();
		JButton[] opButtons = dndLabel.getOutputButtons();
		int xincr = 10;
		int yincr = 10;
		int x = p.x, y = p.y;
		for (JButton btn : ipButtons) {
			if (btn != null) {
				btn.setLocation(new Point(x + xincr, y + yincr));
				btn.setBackground(Color.blue);
				yincr += 20;
				btn.setVisible(true);
				this.add(btn);
			}
		}
		xincr = 100;
		yincr = 10;
		for (JButton btn : opButtons) {
			if (btn != null) {
				btn.setLocation(new Point(x + xincr, y + yincr));
				btn.setBackground(Color.red);
				yincr += 20;
				btn.setVisible(true);
				this.add(btn);
			}
		}

		revalidate();
		repaint();
	}

	/**
	 * The method records the connection between two icons in the right panel
	 * 
	 * @param {DragAndDropLabel} currLabel- the button referance that will be stored
	 *                           as either a previous button or current button
	 *                           myLabels - stores a list of all details related to
	 *                           the icon node edges - stores a list of all arrow
	 *                           edges between the icons
	 * @author Nevedita Kailasam
	 */
	public void addCurrButton(DragAndDropLabel currLabel) {

		if (this.prevLabel != null) {
			this.currLabel = currLabel;
			IconParent currIconParent = this.currLabel.getIconParent();
			IconParent prevIconParent = this.prevLabel.getIconParent();
			if (currIconParent.isInputSpaceAvailable() && prevIconParent.isOutputSpaceAvailable()) {
				currIconParent.addInput(prevIconParent);
				prevIconParent.addOutput(currIconParent);
				Edge edge = new Edge(this.prevLabel, this.currLabel);
				edges.add(edge);
			}

			this.prevLabel = null;
			this.currLabel = null;
			Graph.getInstance().setDnDLabels(myLabels);
			Graph.getInstance().setEdges(edges);
			repaint();
		} else {
			this.prevLabel = currLabel;
		}

	}

	public ArrayList<DragAndDropLabel> getLabels() {
		return this.myLabels;
	}

}
