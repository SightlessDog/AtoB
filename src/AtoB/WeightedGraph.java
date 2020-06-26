package AtoB;

import java.util.LinkedList;
import java.util.List;

public class WeightedGraph {
    //each point has a weight
    class Edge  {
        int v,w ;
        public Edge (int v, int w ) {
            this.v = v  ;
            this.w =w ;
        }

        @Override
        public String toString() {
            return "("+v + "," + w + ")" ;
        }
    }

    List<Edge> G[] ;


    public WeightedGraph(int n) {
        G = new LinkedList[n];
        for (int i = 0 ; i< G.length ; i++ ) {
            G[i]= new LinkedList<Edge>();
        }
    }
    //adds an Edge, takes the starting point u , last point v and weight w
    void AddEdge(int u, int v, int w ) {
        G[u].add(0,new Edge(v,w));
    }
    //checks if connected
    boolean connected (int u , int v) {
        for (Edge i: G[u]) {
            if (i.v == v) return true ;
        }
        return false ;
    }
    @Override
    public String toString() {
        String result = "" ;
        for (int i=0 ; i<G.length;i++ ) {
            result += i+"=>"+G[i]+"\n";
        }
        return result ;
    }

}
