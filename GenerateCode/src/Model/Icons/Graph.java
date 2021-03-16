package Model.Icons;

import View.DragAndDrop.DragAndDropLabel;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class Graph implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static Graph instance;
    List<Edge> edges;
    List<DragAndDropLabel> nodes;

    public static Graph getInstance() {
        if (instance == null) {
            instance = new Graph();
        }
        return instance;
    }

    public List<Edge> getEdges(){
        return this.edges;
    }

    public void setEdges(List<Edge> edges){
        this.edges = edges;
    }

    public void setDnDLabels(List<DragAndDropLabel> nodes){
        this.nodes = nodes;
    }

    public List<DragAndDropLabel> getDnDLabels(){
        return this.nodes;
    }

}
