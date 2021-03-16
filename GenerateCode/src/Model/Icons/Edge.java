package Model.Icons;

import javax.swing.*;
import java.io.Serializable;

public class Edge implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public JButton src, dest;

    public Edge(JButton iButton, JButton jButton) {
        src = iButton;
        dest = jButton;
    }
}
