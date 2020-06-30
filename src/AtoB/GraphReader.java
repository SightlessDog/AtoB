package AtoB;

import AtoB.WeightedGraph.*;

import java.io.*;
import java.util.*;

public class GraphReader {

    static WeightedGraph weightedGraph = new WeightedGraph(9);




    public static void main(String[] args) throws IOException {
        File file = new File ("graph1.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st ;
        String result="" ;

        int count = 1;
        for(;count < 9; count++){
            Node node = new Node(count);
            weightedGraph.allNodes.add(node);

        }
        count = 1;

        while ((st = br.readLine()) != null) {
            String [] graph = st.split("\t",9);
            List<Edge> neighbours = new ArrayList<>();
            for (int i = 1 ; i<graph.length ; i++) {
                int startingPoint = Integer.parseInt(graph[0]);
              //  System.out.println("Starting point : " +startingPoint);
                String[] graph2 = graph[i].split(",");
                int nextPoint = Integer.parseInt(graph2[0]);
               // System.out.println("NextPoint : " +nextPoint);
                int weight = Integer.parseInt(graph2[1]);
               // System.out.println("weight : " +weight)
                //weightedGraph.AddEdge(startingPoint,nextPoint,weight);
                Node start = weightedGraph.getNodeByID(startingPoint);
                Node end = weightedGraph.getNodeByID(nextPoint);

                Edge edge = new Edge(start,end,weight);
                neighbours.add(edge);
            }

            weightedGraph.getNodeByID(count).neighbours = neighbours;
            count++;
        }

        for (Node n:
             weightedGraph.allNodes) {
            System.out.println(n.toString());
        }

        weightedGraph.Dijkstra(3,8);




    }

    public static void dijkstraAlgorithm(){


        // starte im punkt , hab die weight 0
        // schau welche punkte verbunden sind + gehe zum günstigsten
        // die kosten um da hin zu gehen sind die aktuellen kosten, schau welche knoten es jetzt gibt und vergleiche die kosten + aktuelle kosten
        // i want to get the weight of any edge

        System.out.println(weightedGraph.G[5].get(1).getWeight());
        //System.out.println(weightedGraph.G[5].get(1).getVertice());

        /*
        Start somewhere and have kost = 0
        check near by edges and go there, when arrived change their current cost to cost it took to go there
        remember the path you walked there with example previous node/edge etc....

         */


        // z.B
        // Has been visited [(2,1)]
        LinkedList<Edge> visited = new LinkedList<>();


        for(int i = 1; i<weightedGraph.G.length; i++) {
            if (i<8) {
                int j = i + 1;
                System.out.println(weightedGraph.connected(i, j));
            }
            else if (i == 8){
                int j = 1;
                System.out.println(weightedGraph.connected(i, j));
            }

        }

        System.out.println(" ");

        for(int i = weightedGraph.G.length; i>0; i--) {
            if (i < weightedGraph.G.length && i != 1) {
                int j = i - 1;
                System.out.println(weightedGraph.connected(i, j));
            }
            else if (i == 1){
                int j = 8;
                System.out.println(weightedGraph.connected(i, j));
            }

        }
    }






}
