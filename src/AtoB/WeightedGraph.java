package AtoB;

import java.util.*;


public class WeightedGraph {


     Set<Node> allNodes = new HashSet<Node>();
     Set<Node> unvisitedNodes = new HashSet<Node>();
     int startID, endID;

    //each point has a weight
    static class Edge  {
        public Node[] nodes;
         int cost ;

        public Edge (Node Start, Node End, int cost ) {
            this.nodes = new Node[]{Start, End};
            this.cost = cost ;
        }

        public Node[] getVertices() {
            return this.nodes;
        }

        public int getWeight() {
            return cost;
        }

        @Override
        public String toString() {
            return "("+nodes[0]+ ","+ nodes[1]+","+ cost + ")" ;
        }
    }

    List<Edge> G[] ;


    public void Dijkstra(int startID, int endID){
    // Create unvisited set and set tentative score
        this.startID = startID;
        this.endID = endID;
        for (Node n : allNodes) {
            n.visited = false;
            n.score = (n.ID == startID) ? 0 :Integer.MAX_VALUE;
            unvisitedNodes.add(n);
        }
        // get lowest node, Start always has score 0
        Node node = getLowestDistNode();

        while(!unvisitedNodes.isEmpty()){
            // mark current node as visited
            node.visited = true;
            // add to path
            node.shortestPath.add(node);
            // remove from unvisted nodes
            unvisitedNodes.remove(node);

            if(node.ID == endID) unvisitedNodes.clear();
            else {
                // TODO: add scoring function that finds node based on euclidian distance, so that same cost scenarios can be evaluated
                Node cheapest = cheapestNode(node);
                // add previous path to the new node
                cheapest.shortestPath = new LinkedList<>(node.shortestPath);
                // now set cheapest node as current node
                if(cheapest != null)node = cheapest;
                else System.out.println("something is wrong");
            }

        }
        // print final path
        int counter = 0;
        for ( Node n : node.shortestPath) {
            System.out.println( "PATH NODE " +counter+ ": "+ n.ID+" with a cost of "+n.score)   ;
            counter++;
        }

    }
/// this is only to get start Node
    Node getLowestDistNode(){
        int minDist = Integer.MAX_VALUE;
        Node lowest = null;
        for (Node n: unvisitedNodes) {
            if(n.score < minDist){
                if(n.score == 0) return n;
                minDist = n.score;
                lowest = n;
            }
        }
        return lowest;
    }

    Node cheapestNode(Node currentNode){
        int minCost = Integer.MAX_VALUE;
        Node cheapest = null;
        // loop through edges, set cost and save cheapest cost
        for (Edge e : currentNode.neighbours) {
            Node neighbour = e.nodes[1];
            if (!neighbour.visited){
                // set score
                neighbour.score = e.cost + currentNode.score;
                // if neigbour is the end, take this path, regardless of cost
                if(neighbour.ID == endID) return neighbour;
                // if the score is lower than our lowest cost
                if (neighbour.score < minCost){
                    // TODO: Question, is graph unidirectional?
                    // if  so then uncomment this, otherwise take the check out
                    if (neighbour.ID > currentNode.ID){
                        // set node as cheapest
                        minCost = neighbour.score;
                        cheapest = neighbour;
                    }
                    /* set node as cheapest
                    minCost = neighbour.score;
                    cheapest = neighbour;*/
                }
            }
        }
        // after all neighbours are evaluated, return the cheapest node
        return cheapest;
    }

    public Node getNodeByID (int ID){
        for (Node n : allNodes) {
            if (n.ID == ID) return n;
        }
        return null;
    }


    public WeightedGraph(int n) {
        G = new LinkedList[n];
        for (int i = 0 ; i< G.length ; i++ ) {
            G[i]= new LinkedList<Edge>();
        }
    }
    //adds an Edge, takes the starting point u , last point v and weight w
    void AddEdge(int u,  int v, int w ) {
    //    G[u].add(0,new Edge(v,w));
    }

    //checks if connected
    boolean connected (int u , int v) {
        for (Edge i: G[u]) {
         //   if (i.v == v) return true ;
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
