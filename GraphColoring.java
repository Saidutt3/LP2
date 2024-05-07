import java.util.*;

public class GraphColoring {
    private List<Integer>[] graph;
    private int[] colors;
    private int numVertices;
    private int[] solution;

    public GraphColoring(List<Integer>[] graph, int[] colors) {
        this.graph = graph;
        this.colors = colors;
        this.numVertices = graph.length;
        this.solution = new int[numVertices];
        Arrays.fill(this.solution, -1);
    }

    public boolean isSafe(int vertex, int color) {
        for (int neighbor : graph[vertex]) {
            if (solution[neighbor] == color) {
                return false;
            }
        }
        return true;
    }

    public boolean solveGraphColoring(int vertex) {
        if (vertex == numVertices) {
            return true;
        }

        for (int color : colors) {
            if (isSafe(vertex, color)) {
                solution[vertex] = color;

                if (solveGraphColoring(vertex + 1)) {
                    return true;
                }

                solution[vertex] = -1;
            }
        }

        return false;
    }

    public void solve() {
        if (solveGraphColoring(0)) {
            System.out.println("Solution exists:");
            for (int vertex = 0; vertex < numVertices; vertex++) {
                System.out.println("Vertex " + vertex + " -> Color " + solution[vertex]);
            }
        } else {
            System.out.println("No solution exists.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        List<Integer>[] graph = new List[numVertices];
        for (int i = 0; i < numVertices; i++) {
            graph[i] = new ArrayList<>();
        }

        System.out.println("Enter the adjacency list for the graph (enter -1 to end a list):");
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Enter neighbors of vertex " + i + ": ");
            int neighbor = scanner.nextInt();
            while (neighbor != -1) {
                graph[i].add(neighbor);
                neighbor = scanner.nextInt();
            }
        }

        System.out.print("Enter the number of colors: ");
        int numColors = scanner.nextInt();

        int[] colors = new int[numColors];
        System.out.println("Enter the colors (integers):");
        for (int i = 0; i < numColors; i++) {
            colors[i] = scanner.nextInt();
        }

        GraphColoring graphColoring = new GraphColoring(graph, colors);
        graphColoring.solve();

        scanner.close();
    }
}
