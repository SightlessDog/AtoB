package AtoB;

import java.io.*;

public class GraphReader {
    public static void main(String[] args) throws IOException {
        File file = new File ("C:\\Users\\ely36\\Documents\\test.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st ;
        String result="" ;
       // while ((st = br.readLine()) != null) {
         //   result += st ;
       // }
        WeightedGraph weightedGraph = new WeightedGraph(8);

        while ((st = br.readLine()) != null) {
            String [] graph = result.split("\t",5);
            for (int i = 1 ; i<graph.length ; i++) {
                int startingPoint = Integer.parseInt(graph[0]);
                System.out.println(startingPoint);
                System.out.println(startingPoint);
                String[] graph2 = graph[i].split(",");
                int nextPoint = Integer.parseInt(graph2[0]);
                int weight = Integer.parseInt(graph2[1]);

                weightedGraph.AddEdge(startingPoint,nextPoint,weight);
            }
        }


    }

}
