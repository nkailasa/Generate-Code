package Model.Icons;

import java.io.Serializable;

import View.DragAndDrop.DragAndDropLabel;

/**
 * This class has the structure of an edge created between two buttons
 * 
 * @author Nevedita Kailasam
 */
public class Edge implements Serializable {

    private static final long serialVersionUID = 1L;
    public DragAndDropLabel src, dest;

    public Edge(DragAndDropLabel iButton, DragAndDropLabel jButton) {
        src = iButton;
        dest = jButton;
    }
}
