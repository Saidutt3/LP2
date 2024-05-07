import java.util.*;

public class PrimsAlgorithm {

    static int V;

    static int primMST(List<List<Integer>> graph) {
        int[] parent = new int[V]; // Array to store constructed MST
        int[] key = new int[V]; // Key values used to pick minimum weight edge in cut
        boolean[] mstSet = new boolean[V]; // To represent set of vertices not yet included in MST

        // Initialize all keys as INFINITE
        Arrays.fill(key, Integer.MAX_VALUE);

        // Always include first vertex in MST.
        // Make key 0 so that this vertex is picked as first vertex
        key[0] = 0;
        parent[0] = -1; // First node is always root of MST

        // The MST will have V vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum key vertex from the set of vertices not yet included in MST
            int u = minKey(key, mstSet);

            // Add the picked vertex to the MST set
            mstSet[u] = true;

            // Update key value and parent index of the adjacent vertices of the picked
            // vertex.
            // Consider only those vertices which are not yet included in MST
            for (int v = 0; v < V; v++) {
                // graph.get(u).get(v) is non-zero only for adjacent vertices of m
                // mstSet[v] is false for vertices not yet included in MST
                // Update the key only if graph.get(u).get(v) is smaller than key[v]
                if (graph.get(u).get(v) != 0 && !mstSet[v] && graph.get(u).get(v) < key[v]) {
                    parent[v] = u;
                    key[v] = graph.get(u).get(v);
                }
            }
        }

        // Print the constructed MST
        int totalWeight = 0;
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph.get(i).get(parent[i]));
            totalWeight += graph.get(i).get(parent[i]);
        }

        return totalWeight;
    }

    // A utility function to find the vertex with minimum key
    // value, from the set of vertices not yet included in MST
    static int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        }

        return min_index;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        V = scanner.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.println("Enter the adjacency list (enter -1 to end a list):");
        for (int i = 0; i < V; i++) {
            System.out.print("Enter neighbors of vertex " + i + ": ");
            int neighbor = scanner.nextInt();
            while (neighbor != -1) {
                graph.get(i).add(neighbor);
                neighbor = scanner.nextInt();
            }
        }

        int totalWeight = primMST(graph);
        System.out.println("Total weight of MST: " + totalWeight);

        scanner.close();
    }
}
