package AtoB;

import AtoB.WeightedGraph.Edge;

import java.io.*;
import java.util.*;

public class GraphReader {

    static WeightedGraph weightedGraph = new WeightedGraph(9);




    public static void main(String[] args) throws IOException {
        File file = new File ("C:\\Users\\Miri\\Desktop\\graph1.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st ;
        String result="" ;
       // while ((st = br.readLine()) != null) {
         //   result += st ;
       // }

        while ((st = br.readLine()) != null) {
            String [] graph = st.split("\t",9);
            System.out.println(graph[1]);

            for (int i = 1 ; i<graph.length ; i++) {
                int startingPoint = Integer.parseInt(graph[0]);
                String[] graph2 = graph[i].split(",");
                System.out.println("bla"+graph2[1]);
                int nextPoint = Integer.parseInt(graph2[0]);
                int weight = Integer.parseInt(graph2[1]);
                weightedGraph.AddEdge(startingPoint,nextPoint,weight);
            }
        }
        System.out.println(weightedGraph.toString());

        dijkstraAlgorithm();

    }

    public static void dijkstraAlgorithm(){


        // starte im punkt , hab die weight 0
        // schau welche punkte verbunden sind + gehe zum günstigsten
        // die kosten um da hin zu gehen sind die aktuellen kosten, schau welche knoten es jetzt gibt und vergleiche die kosten + aktuelle kosten





        // i want to get the weight of any edge

        System.out.println(weightedGraph.G[5].get(1).getWeight());
        System.out.println(weightedGraph.G[5].get(1).getVertice());



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
