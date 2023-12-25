package SystemSolveSudoku;

public class Edge {
    private Vertex u;
    private Vertex v;


    public Edge(Vertex u1 , Vertex v1){
        this.u = u1;
        this.v = v1;
    }
    public int getValueU(){
        return u.getValue();
    }
    public int getValueV(){
        return v.getValue();
    }
    public Vertex getU(){
        return u;
    }
    public Vertex getV(){
        return v;
    }
}
