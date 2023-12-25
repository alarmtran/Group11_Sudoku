package SystemSolveSudoku;

import java.util.ArrayList;

public class Vertex {

    private int value;

    private ArrayList<Vertex> nearVertex = new ArrayList<>();

    public Vertex(){

    }
    public void setValue(int value){
        this.value = value;
    }


    public Vertex(int value){
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }
    public void addNeighbor(Vertex e){
        this.nearVertex.add(e);
        e.nearVertex.add(this);
    }
    public ArrayList<Vertex> getNeighbor(){
        return nearVertex;
    }
}
