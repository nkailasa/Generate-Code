package Model.Icons;

import java.util.List;

import View.DragAndDrop.DragAndDropLabel;

public class Graph {
    private static Graph instance;
    List<Edge> edges;
    List<DragAndDropLabel> nodes;
    public static Graph getInstance(){
        if(instance == null){
            instance = new Graph();
        }
        return instance;
    }

    public List<Edge> getEdges(){
        return this.edges;
    }

    public void setEdges(List<Edge> edges){
        this.edges = edges;
        System.out.println(edges);
    }

    public void setDnDLabels(List<DragAndDropLabel> nodes){
        this.nodes = nodes;
        System.out.println(nodes);
    }

    public List<DragAndDropLabel> getDnDLabels(){
        return this.nodes;
    }

}
