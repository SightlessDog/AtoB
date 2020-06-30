package AtoB;

import java.util.LinkedList;
import java.util.List;

public class WeightedGraph {
    //each point has a weight
     class Edge  {
         String v;
         String w ;
        public Edge (String v, String w ) {
            this.v = v  ;
            this.w =w ;
        }

        public String getVertice() {
            return v;
        }

        public String getWeight() {
            return w;
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
    void AddEdge(int u,  String v, String w ) {
        G[u].add(new Edge(v,w));
    }

    //checks if connected
    boolean connected (int u , int v) {
        for (Edge i: G[u]) {
            if (i.v.equals(v)) return true ;
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
