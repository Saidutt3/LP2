import java.util.*;

class BFS {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency list

    // Constructor
    BFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the BFS
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Prints BFS traversal from a given source s
    void BFS(int s) {
        // Mark all the vertices as not visited (by default set as false)
        boolean[] visited = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from the queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s. If an adjacent
            // has not been visited, then mark it visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // Driver method to
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();
        BFS g = new BFS(V);

        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();

        System.out.println("Enter the edges (source destination):");
        for (int i = 0; i < E; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            g.addEdge(src, dest);
        }

        System.out.print("Enter the starting vertex for BFS traversal: ");
        int startVertex = scanner.nextInt();

        System.out.println("BFS traversal:");
        g.BFS(startVertex);

        scanner.close();
    }
}
