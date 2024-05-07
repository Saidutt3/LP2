import java.util.*;

class DFS {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency list

    // Constructor
    DFS(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the DFS
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // A recursive function to perform DFS starting from vertex v
    void DFSUtil(int v, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v) {
        // Mark all the vertices as not visited(set as false by default in java)
        boolean[] visited = new boolean[V];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }

    // Driver method to
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();
        DFS g = new DFS(V);

        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();

        System.out.println("Enter the edges (source destination):");
        for (int i = 0; i < E; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            if (src >= 0 && src < V && dest >= 0 && dest < V) {
                g.addEdge(src, dest);
            } else {
                System.out.println("Invalid edge. Enter a valid edge.");
                i--; // Decrement i to re-enter the current edge
            }
        }

        System.out.print("Enter the starting vertex for DFS traversal: ");
        int startVertex = scanner.nextInt();
        if (startVertex >= 0 && startVertex < V) {
            System.out.println("DFS traversal:");
            g.DFS(startVertex);
        } else {
            System.out.println("Invalid start vertex. Please enter a valid vertex.");
        }

        scanner.close();
    }
}
