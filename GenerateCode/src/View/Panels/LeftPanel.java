package View.Panels;

import Model.Icons.*;
import View.DragAndDrop.DragAndDropLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import Model.Icons.AtSymbol;
import Model.Icons.DoublePipe;
import Model.Icons.GreaterThan;
import Model.Icons.Hyphen;
import Model.Icons.LParen;
import Model.Icons.LessThan;
import Model.Icons.RParen;
import View.DragAndDrop.DragAndDropLabel;

public class LeftPanel extends JPanel { // drag source
	private static final long serialVersionUID = -1827724962934234619L;
	DragAndDropLabel lparen;
	DragAndDropLabel rparen;
	DragAndDropLabel lessThan;
	DragAndDropLabel greaterThan;
	DragAndDropLabel hyphen;
	DragAndDropLabel pipe;
	DragAndDropLabel at;

	public static JPanel getNewLabelFromText(String text) {
		DragAndDropLabel newLabel = null;
		JPanel p = new JPanel();
		JButton input1 = new JButton();
		input1.setPreferredSize(new Dimension(10, 10));
		JButton input2 = new JButton();
		input2.setPreferredSize(new Dimension(10, 10));
		JButton output1 = new JButton();
		output1.setPreferredSize(new Dimension(10, 10));
		JButton output2 = new JButton();
		output2.setPreferredSize(new Dimension(10, 10));
		JButton inputBar = new JButton();
		inputBar.setPreferredSize(new Dimension(10, 20));
		JButton outputBar = new JButton();
		outputBar.setPreferredSize(new Dimension(10, 20));

		switch (text) {
		case " ( .":
			newLabel = new DragAndDropLabel(new LParen());
			output1.setName("LParenOutput1");
			output1.setNextFocusableComponent(newLabel);
			newLabel.setOutputButton(0, output1);
			p.add(newLabel);
			p.add(output1);
			break;
		case ". ) ":
			newLabel = new DragAndDropLabel(new RParen());
			input1.setName("RParenInput1");
			input1.setNextFocusableComponent(newLabel);
			newLabel.setInputButton(0, input1);
			p.add(input1);
			p.add(newLabel);
			break;
		case ".  <  :":
			newLabel = new DragAndDropLabel(new LessThan());
			output1.setName("LessThanOutput2");
			output2.setName("LessThanOutput1");
			newLabel.setOutputButton(0, output1);
			newLabel.setOutputButton(1, output2);
			input1.setName("LessThanInput1");
			newLabel.setInputButton(0, input1);
			input1.setNextFocusableComponent(newLabel);
			output1.setNextFocusableComponent(newLabel);
			output2.setNextFocusableComponent(newLabel);
			p.add(input1);
			p.add(newLabel);
			p.add(output1);
			p.add(output2);
			break;
		case ":  >  .":
			newLabel = new DragAndDropLabel(new GreaterThan());
			input2.setName("GreaterThanInput2");
			output1.setName("GreaterThanOutput1");
			input1.setName("GreaterThanInput1");
			newLabel.setOutputButton(0, output1);
			newLabel.setInputButton(0, input1);
			newLabel.setInputButton(1, input2);
			input1.setNextFocusableComponent(newLabel);
			input2.setNextFocusableComponent(newLabel);
			output1.setNextFocusableComponent(newLabel);
			p.add(input2);
			p.add(input1);
			p.add(newLabel);
			p.add(output1);
			break;
		case ".  --  .":
			newLabel = new DragAndDropLabel(new Hyphen());
			output1.setName("HypenOutput1");
			input1.setName("HypenInput1");
			newLabel.setOutputButton(0, output1);
			newLabel.setInputButton(0, input1);
			input1.setNextFocusableComponent(newLabel);
			output1.setNextFocusableComponent(newLabel);
			p.add(input1);
			p.add(newLabel);
			p.add(output1);
			break;
		case "  @  ":
			newLabel = new DragAndDropLabel(new AtSymbol());
			output1.setName("AtOutput1");
			input1.setName("AtInput1");
			output2.setName("AtOutput2");
			input2.setName("AtInput2");
			newLabel.setInputButton(0, input1);
			newLabel.setInputButton(1, input2);
			newLabel.setOutputButton(0, output1);
			newLabel.setOutputButton(1, output2);
			input1.setNextFocusableComponent(newLabel);
			input2.setNextFocusableComponent(newLabel);
			output1.setNextFocusableComponent(newLabel);
			output2.setNextFocusableComponent(newLabel);
			p.add(input1);
			p.add(input2);
			p.add(newLabel);
			p.add(output1);
			p.add(output2);
			break;
		case "*  |  |  *":
			newLabel = new DragAndDropLabel(new DoublePipe());
			inputBar.setName("DoublePipeInput");
			outputBar.setName("DoublePipeOutput");
			inputBar.setNextFocusableComponent(newLabel);
			outputBar.setNextFocusableComponent(newLabel);
			newLabel.setInputButton(0, inputBar);
			newLabel.setOutputButton(0, outputBar);
			p.add(inputBar);
			p.add(newLabel);
			p.add(outputBar);			
			break;
		default:
			System.out.println("DEFAULT!");
		}

		return p;
	}

	public LeftPanel(DragGestureListener dragGestureListener) {
		super(new GridLayout(7, 0, 5, 5));
		setBorder(BorderFactory.createLineBorder(Color.gray));

		DragSource ds;

		ds = new DragSource();
		this.lparen = new DragAndDropLabel(new LParen());
		ds.createDefaultDragGestureRecognizer(this.lparen, DnDConstants.ACTION_COPY, dragGestureListener);

		ds = new DragSource();
		this.rparen = new DragAndDropLabel(new RParen());
		ds.createDefaultDragGestureRecognizer(this.rparen, DnDConstants.ACTION_COPY, dragGestureListener);

		ds = new DragSource();
		this.lessThan = new DragAndDropLabel(new LessThan());
		ds.createDefaultDragGestureRecognizer(this.lessThan, DnDConstants.ACTION_COPY, dragGestureListener);

		ds = new DragSource();
		this.greaterThan = new DragAndDropLabel(new GreaterThan());
		ds.createDefaultDragGestureRecognizer(this.greaterThan, DnDConstants.ACTION_COPY, dragGestureListener);

		ds = new DragSource();
		this.hyphen = new DragAndDropLabel(new Hyphen());
		ds.createDefaultDragGestureRecognizer(this.hyphen, DnDConstants.ACTION_COPY, dragGestureListener);

		ds = new DragSource();
		this.at = new DragAndDropLabel(new AtSymbol());
		ds.createDefaultDragGestureRecognizer(this.at, DnDConstants.ACTION_COPY, dragGestureListener);

		ds = new DragSource();
		this.pipe = new DragAndDropLabel(new DoublePipe());
		ds.createDefaultDragGestureRecognizer(this.pipe, DnDConstants.ACTION_COPY, dragGestureListener);

		this.add(lparen);
		this.add(rparen);
		this.add(lessThan);
		this.add(greaterThan);
		this.add(hyphen);
		this.add(at);
		this.add(pipe);

	}

}
