import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MCCR {
    public static int MCCR(EdgeWeightedGraph G) {
        int V = G.numberOfV();
        boolean[] inGraph = new boolean[V];
        int[] keys = new int[V];
        Arrays.fill(keys, Integer.MAX_VALUE);
        keys[0] = 0;

        for(int i = 0; i < V; i++) {
            int v = minVer(inGraph,keys,V);
            inGraph[v] = true;

            Iterable<Edge> edges = G.edges(v);
            for(Edge e : edges) {
                int other = e.other(v);
                if(!inGraph[other]) {
                    keys[other] = (e.weight() < keys[other]) ? e.weight() : keys[other];
                }
            }
        }

        return sum(keys);
    }

    public static int minVer(boolean[] inGraph, int[] keys, int V) {
        int minVal = Integer.MAX_VALUE;
        int min_index = -1;

        for(int i = 0 ; i < V; i++) {
            if(!inGraph[i] && keys[i] < minVal) {
                minVal = keys[i];
                min_index = i;
            }
        }
        return min_index;
    }

    public static int sum(int[] keys) {
        int sum = 0;
        for(int k : keys) { sum += k; }
        return sum;
    }

}

