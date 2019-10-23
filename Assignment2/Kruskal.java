import java.util.*;

public class Kruskal{

    public static WGraph kruskal(WGraph g){

        WGraph MSTGraph = new WGraph();
        ArrayList<Edge> sorted_edges = g.listOfEdgesSorted();
        int nbNodes = g.getNbNodes();

        DisjointSets disjointSet = new DisjointSets(nbNodes);
        for (int i = 0; i < sorted_edges.size(); i++) {
            if (IsSafe(disjointSet, sorted_edges.get(i))) {
                MSTGraph.addEdge(sorted_edges.get(i));
                int n0 = sorted_edges.get(i).nodes[0];
                int n1 = sorted_edges.get(i).nodes[1];
                disjointSet.union(n0,n1);
            }
        }
        /* Fill this method (The statement return null is here only to compile) */
        
        return MSTGraph;
    }

    public static Boolean IsSafe(DisjointSets p, Edge e){

        boolean IsSafe = false;
        int n0 = e.nodes[0];
        int n1 = e.nodes[1];
        if (p.find(n0) != p.find(n1)) {
            IsSafe = true;
        }
        return IsSafe;
        /* Fill this method (The statement return 0 is here only to compile) */
    
    }

    public static void main(String[] args){

        String file = args[0];
        WGraph g = new WGraph(file);
        WGraph t = kruskal(g);
        System.out.println(t);

   } 
}
