package View.Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import View.DragAndDrop.AddValueModal;
import View.DragAndDrop.DragAndDropLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RightPanel extends JPanel { // drop target
    private static final long serialVersionUID = 5237869471969999584L;

    ArrayList<DragAndDropLabel> myLabels = new ArrayList<>();

    public RightPanel() {
        super();
        setBorder(BorderFactory.createLineBorder(Color.darkGray));
    }

    @Override
    public void paintComponent(Graphics graphics) {
        System.out.println("Painting graphics");
        // super.paintComponent(graphics);

        for (DragAndDropLabel myLabel : myLabels) { // draw rest components
            int x = (int) myLabel.getDroppedAtX();
            int y = (int) myLabel.getDroppedAtY();

            myLabel.setLocation(new Point(x, y));
            myLabel.setVisible(true);
            myLabel.paint(graphics);
            this.add(myLabel);
        }

        super.paintComponent(graphics);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    public void createAndAddDnDLabel(String labelText, Point p) {
        DragAndDropLabel label = LeftPanel.getNewLabelFromText(labelText);
        label.setCoordinates(p);
        label.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    AddValueModal modal = AddValueModal.getInstance();
                    modal.setIcon(label);
                    modal.setInputText(label.getIconParent().getValue());
                    modal.setVisible(true);
                }
              }
        });
        myLabels.add(label);

        label.setLocation(p);
        label.setVisible(true);
        this.add(label);
        
        revalidate();
        repaint();
    }

    public void addDragAndDropLabel(DragAndDropLabel l) {
        myLabels.add(l);
        revalidate();
        repaint();
    }
}
