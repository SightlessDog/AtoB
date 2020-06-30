package AtoB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Node {
    public int ID, score;
    public List<WeightedGraph.Edge> neighbours;
    public List<Node> shortestPath = new LinkedList<>();
    public boolean visited;

    public Node(int ID){
        this.ID = ID;
        this.visited = false;
        this.neighbours = new ArrayList<>();
    }
    @Override
    public String toString() {
        return "( Node ID : " + ID +" || N1 : "+ neighbours.get(0).nodes[1].ID+" || N2 : "+ neighbours.get(1).nodes[1].ID+ ")";
    }


}
