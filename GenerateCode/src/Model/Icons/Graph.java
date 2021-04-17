package Model.Icons;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import View.DragAndDrop.DragAndDropLabel;

public class Graph implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static Graph instance;
    List<Edge> edges;
    List<DragAndDropLabel> nodes;
    protected Map<String,Integer> iconCount = new HashMap<String,Integer>();

    public static Graph getInstance() {
        if (instance == null) {
            instance = new Graph();
        }
        return instance;
    }

    public List<Edge> getEdges() {
        return this.edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public Map<String,Integer> getIconCount() {
        return this.iconCount;
    }

    public void setIconCount(Map<String,Integer> iconCount) {
        this.iconCount=iconCount;
    }

    public void setDnDLabels(List<DragAndDropLabel> nodes) {
        this.nodes = nodes;
    }

    public List<DragAndDropLabel> getDnDLabels() {
        return this.nodes;
    }

}
