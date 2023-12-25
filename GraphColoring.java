public class GraphColoring {
    private int V, numOfColor;
    private int[] color;
    private int[][] graph;

    // Function to assign color
    public void graphColor(int[][] g, int noc) {
        V = g.length;
        numOfColor = noc;
        color = new int[V];
        graph = g;

        try {
            solve(0);
            System.out.println("No solution");
        }
        catch (Exception e) {
            System.out.println("\nSolution exists ");
            display();
        }
    }

    // Hàm gán màu đệ quy
    public void solve(int v) throws Exception {
        if (v == V) {
            throw new Exception("Solution found");
        }
        for (int c = 1; c <= numOfColor; c++) {
            if (isPossible(v, c)) {
                // Gán và tiếp tục đến điểm tiếp theo
                color[v] = c;
                solve(v + 1);
                color[v] = 0;
            }
        }
    }

    public boolean isPossible(int v, int c) {
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && c == color[i]) {
                return false;
            }
        }
        return true;
    }

    public void display() {
        System.out.println("Colors: ");
        for (int i = 0; i < V; i++) {
            System.out.print(color[i] + " ");
        }
        System.out.println();
    }


}