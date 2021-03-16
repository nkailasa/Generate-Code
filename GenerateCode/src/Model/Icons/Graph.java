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
            System.out.println("Creating new instance");
            instance = new Graph();
        }
        return instance;
    }

    public List<Edge> getEdges(){
        return this.edges;
    }

    public void setEdges(List<Edge> edges){
        this.edges = edges;
        System.out.println(this.edges);
    }

    public void setDnDLabels(List<DragAndDropLabel> nodes){
        this.nodes = nodes;
        System.out.println(this.nodes);
    }

    public List<DragAndDropLabel> getDnDLabels(){
        return this.nodes;
    }

}
