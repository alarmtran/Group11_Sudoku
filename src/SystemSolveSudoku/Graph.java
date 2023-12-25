package SystemSolveSudoku;

import java.util.ArrayList;

public class Graph {
    private int[][] graphMatrix;
    ArrayList<Vertex> listVertex = new ArrayList<>();
    ArrayList<Edge> listEdge = new ArrayList<>();
    int[][] data;
    int[] index;
    public Graph(int[][] data){
        this.data = data;
    }
    public Vertex insertVertex(int x){
        Vertex v = new Vertex(x);
        listVertex.add(v);
        return v;
    }
    public ArrayList<Vertex> listVertex(){
        return this.listVertex;
    }
    public void insertVertex(Vertex v){
        listVertex.add(v);
    }
    public Edge insertEdge(Vertex u, Vertex v){
        Edge myEdge = new Edge(u,v);
        u.addNeighbor(v);
        v.addNeighbor(u);
        listEdge.add(myEdge);
        updateMatrix();
        return myEdge;
    }
    public int numVertices(){
        return listVertex.size();
    }
    public ArrayList<Vertex> vertices(){
        return listVertex;
    }
    public int numEdges(){
        return listEdge.size();
    }
    public ArrayList<Edge> edges(){
        return listEdge;
    }
    public Edge getEdge(Vertex u , Vertex v){
        for(Edge e : listEdge){
            if((e.getValueV() == v.getValue() || e.getValueV() == u.getValue()) && (e.getValueU() == v.getValue() || e.getValueU() == u.getValue())){
                return e;
            }
        }
        return null;
    }
    private void updateMatrix(){
        graphMatrix = new int[listVertex.size()][listVertex.size()];
        int max = listVertex.get(0).getValue();
        for(int i=0;i<listVertex.size();i++){
            if(max < listVertex.get(i).getValue()){
                max = listVertex.get(i).getValue();
            }
        }
        index = new int[max+1];
        for(int i=0;i<listVertex.size();i++){
            index[listVertex.get(i).getValue()] = i;
        }
        for(int i=0;i<graphMatrix.length;i++){
            Vertex curVertex = listVertex.get(i);
            ArrayList<Vertex> neighbor = curVertex.getNeighbor();
            for(int j=0;j<neighbor.size();j++){
                graphMatrix[i][index[neighbor.get(j).getValue()]]++;
            }
        }
    }

    public Vertex[] getCells(){
        Vertex[] cells = new Vertex[81];
        for(int i=0;i<81;i++){
            cells[i] = listVertex.get(i);
        }
        return cells;
    }
    public void print(){
        if(graphMatrix == null){
            return;
        }
        for(int[] a : graphMatrix){
            for(int b : a){
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
    public void init(){
        Vertex v1 = new Vertex(data[0][0]);
        Vertex v2 = new Vertex(data[0][1]);
        Vertex v3 = new Vertex(data[0][2]);
        Vertex v4 = new Vertex(data[0][3]);
        Vertex v5 = new Vertex(data[0][4]);
        Vertex v6 = new Vertex(data[0][5]);
        Vertex v7 = new Vertex(data[0][6]);
        Vertex v8 = new Vertex(data[0][7]);
        Vertex v9 = new Vertex(data[0][8]);
        Vertex v10 = new Vertex(data[1][0]);
        Vertex v11 = new Vertex(data[1][1]);
        Vertex v12 = new Vertex(data[1][2]);
        Vertex v13 = new Vertex(data[1][3]);
        Vertex v14 = new Vertex(data[1][4]);
        Vertex v15 = new Vertex(data[1][5]);
        Vertex v16 = new Vertex(data[1][6]);
        Vertex v17 = new Vertex(data[1][7]);
        Vertex v18 = new Vertex(data[1][8]);
        Vertex v19 = new Vertex(data[2][0]);
        Vertex v20 = new Vertex(data[2][1]);
        Vertex v21 = new Vertex(data[2][2]);
        Vertex v22 = new Vertex(data[2][3]);
        Vertex v23 = new Vertex(data[2][4]);
        Vertex v24 = new Vertex(data[2][5]);
        Vertex v25 = new Vertex(data[2][6]);
        Vertex v26 = new Vertex(data[2][7]);
        Vertex v27 = new Vertex(data[2][8]);
        Vertex v28 = new Vertex(data[3][0]);
        Vertex v29 = new Vertex(data[3][1]);
        Vertex v30 = new Vertex(data[3][2]);
        Vertex v31 = new Vertex(data[3][3]);
        Vertex v32 = new Vertex(data[3][4]);
        Vertex v33 = new Vertex(data[3][5]);
        Vertex v34 = new Vertex(data[3][6]);
        Vertex v35 = new Vertex(data[3][7]);
        Vertex v36 = new Vertex(data[3][8]);
        Vertex v37 = new Vertex(data[4][0]);
        Vertex v38 = new Vertex(data[4][1]);
        Vertex v39 = new Vertex(data[4][2]);
        Vertex v40 = new Vertex(data[4][3]);
        Vertex v41 = new Vertex(data[4][4]);
        Vertex v42 = new Vertex(data[4][5]);
        Vertex v43 = new Vertex(data[4][6]);
        Vertex v44 = new Vertex(data[4][7]);
        Vertex v45 = new Vertex(data[4][8]);
        Vertex v46 = new Vertex(data[5][0]);
        Vertex v47 = new Vertex(data[5][1]);
        Vertex v48 = new Vertex(data[5][2]);
        Vertex v49 = new Vertex(data[5][3]);
        Vertex v50 = new Vertex(data[5][4]);
        Vertex v51 = new Vertex(data[5][5]);
        Vertex v52 = new Vertex(data[5][6]);
        Vertex v53 = new Vertex(data[5][7]);
        Vertex v54 = new Vertex(data[5][8]);
        Vertex v55 = new Vertex(data[6][0]);
        Vertex v56 = new Vertex(data[6][1]);
        Vertex v57 = new Vertex(data[6][2]);
        Vertex v58 = new Vertex(data[6][3]);
        Vertex v59 = new Vertex(data[6][4]);
        Vertex v60 = new Vertex(data[6][5]);
        Vertex v61 = new Vertex(data[6][6]);
        Vertex v62 = new Vertex(data[6][7]);
        Vertex v63 = new Vertex(data[6][8]);
        Vertex v64 = new Vertex(data[7][0]);
        Vertex v65 = new Vertex(data[7][1]);
        Vertex v66 = new Vertex(data[7][2]);
        Vertex v67 = new Vertex(data[7][3]);
        Vertex v68 = new Vertex(data[7][4]);
        Vertex v69 = new Vertex(data[7][5]);
        Vertex v70 = new Vertex(data[7][6]);
        Vertex v71 = new Vertex(data[7][7]);
        Vertex v72 = new Vertex(data[7][8]);
        Vertex v73 = new Vertex(data[8][0]);
        Vertex v74 = new Vertex(data[8][1]);
        Vertex v75 = new Vertex(data[8][2]);
        Vertex v76 = new Vertex(data[8][3]);
        Vertex v77 = new Vertex(data[8][4]);
        Vertex v78 = new Vertex(data[8][5]);
        Vertex v79 = new Vertex(data[8][6]);
        Vertex v80 = new Vertex(data[8][7]);
        Vertex v81 = new Vertex(data[8][8]);

        //Theo ngang
        v1.addNeighbor(v2);
        v1.addNeighbor(v3);
        v1.addNeighbor(v4);
        v1.addNeighbor(v5);
        v1.addNeighbor(v6);
        v1.addNeighbor(v7);
        v1.addNeighbor(v8);
        v1.addNeighbor(v9);
        //Theo dọc
        v1.addNeighbor(v10);
        v1.addNeighbor(v19);
        v1.addNeighbor(v28);
        v1.addNeighbor(v37);
        v1.addNeighbor(v46);
        v1.addNeighbor(v55);
        v1.addNeighbor(v64);
        v1.addNeighbor(v73);
        //Theo khối
        v1.addNeighbor(v11);
        v1.addNeighbor(v12);
        v1.addNeighbor(v20);
        v1.addNeighbor(v21);
        ////////////////////
        //Theo ngang
        v2.addNeighbor(v3);
        v2.addNeighbor(v4);
        v2.addNeighbor(v5);
        v2.addNeighbor(v6);
        v2.addNeighbor(v7);
        v2.addNeighbor(v8);
        v2.addNeighbor(v9);
        //Theo dọc
        v2.addNeighbor(v10);
        v2.addNeighbor(v20);
        v2.addNeighbor(v29);
        v2.addNeighbor(v38);
        v2.addNeighbor(v47);
        v2.addNeighbor(v56);
        v2.addNeighbor(v65);
        v2.addNeighbor(v74);
        //Theo khối
        v2.addNeighbor(v10);
        v2.addNeighbor(v19);
        v2.addNeighbor(v12);
        v2.addNeighbor(v21);
        ////////////////////
        //Theo ngang
        v3.addNeighbor(v4);
        v3.addNeighbor(v5);
        v3.addNeighbor(v6);
        v3.addNeighbor(v7);
        v3.addNeighbor(v8);
        v3.addNeighbor(v9);
        //Theo dọc
        v3.addNeighbor(v12);
        v3.addNeighbor(v21);
        v3.addNeighbor(v30);
        v3.addNeighbor(v39);
        v3.addNeighbor(v48);
        v3.addNeighbor(v57);
        v3.addNeighbor(v66);
        v3.addNeighbor(v75);
        //Theo khối
        v3.addNeighbor(v10);
        v3.addNeighbor(v11);
        v3.addNeighbor(v19);
        v3.addNeighbor(v20);
        ////////////////////
        //Theo ngang
        v4.addNeighbor(v5);
        v4.addNeighbor(v6);
        v4.addNeighbor(v7);
        v4.addNeighbor(v8);
        v4.addNeighbor(v9);
        //Theo dọc
        v4.addNeighbor(v13);
        v4.addNeighbor(v22);
        v4.addNeighbor(v31);
        v4.addNeighbor(v40);
        v4.addNeighbor(v49);
        v4.addNeighbor(v58);
        v4.addNeighbor(v67);
        v4.addNeighbor(v76);
        //Theo khối
        v4.addNeighbor(v14);
        v4.addNeighbor(v15);
        v4.addNeighbor(v23);
        v4.addNeighbor(v24);
        ////////////////////
        //Theo ngang
        v5.addNeighbor(v6);
        v5.addNeighbor(v7);
        v5.addNeighbor(v8);
        v5.addNeighbor(v9);
        //Theo dọc
        v5.addNeighbor(v14);
        v5.addNeighbor(v23);
        v5.addNeighbor(v32);
        v5.addNeighbor(v41);
        v5.addNeighbor(v50);
        v5.addNeighbor(v59);
        v5.addNeighbor(v68);
        v5.addNeighbor(v77);
        //Theo khối
        v5.addNeighbor(v13);
        v5.addNeighbor(v15);
        v5.addNeighbor(v22);
        v5.addNeighbor(v24);
        ////////////////////
        //Theo ngang
        v6.addNeighbor(v7);
        v6.addNeighbor(v8);
        v6.addNeighbor(v9);
        //Theo dọc
        v6.addNeighbor(v15);
        v6.addNeighbor(v24);
        v6.addNeighbor(v33);
        v6.addNeighbor(v42);
        v6.addNeighbor(v51);
        v6.addNeighbor(v60);
        v6.addNeighbor(v69);
        v6.addNeighbor(v78);
        //Theo khối
        v6.addNeighbor(v13);
        v6.addNeighbor(v14);
        v6.addNeighbor(v22);
        v6.addNeighbor(v23);
        ////////////////////
        //Theo ngang
        v7.addNeighbor(v8);
        v7.addNeighbor(v9);
        //Theo dọc
        v7.addNeighbor(v16);
        v7.addNeighbor(v25);
        v7.addNeighbor(v34);
        v7.addNeighbor(v43);
        v7.addNeighbor(v52);
        v7.addNeighbor(v61);
        v7.addNeighbor(v70);
        v7.addNeighbor(v79);
        //Theo khối
        v7.addNeighbor(v17);
        v7.addNeighbor(v18);
        v7.addNeighbor(v26);
        v7.addNeighbor(v27);
        ////////////////////
        //Theo ngang
        v8.addNeighbor(v9);
        //Theo dọc
        v8.addNeighbor(v17);
        v8.addNeighbor(v26);
        v8.addNeighbor(v35);
        v8.addNeighbor(v44);
        v8.addNeighbor(v53);
        v8.addNeighbor(v62);
        v8.addNeighbor(v71);
        v8.addNeighbor(v80);
        //Theo khối
        v8.addNeighbor(v16);
        v8.addNeighbor(v18);
        v8.addNeighbor(v25);
        v8.addNeighbor(v27);
        ////////////////////
        //Theo ngang
        //Theo dọc
        v9.addNeighbor(v18);
        v9.addNeighbor(v27);
        v9.addNeighbor(v36);
        v9.addNeighbor(v45);
        v9.addNeighbor(v54);
        v9.addNeighbor(v63);
        v9.addNeighbor(v72);
        v9.addNeighbor(v81);
        //Theo khối
        v9.addNeighbor(v16);
        v9.addNeighbor(v17);
        v9.addNeighbor(v25);
        v9.addNeighbor(v26);
        ////////////////////
        //Theo ngang
        v10.addNeighbor(v11);
        v10.addNeighbor(v12);
        v10.addNeighbor(v13);
        v10.addNeighbor(v14);
        v10.addNeighbor(v15);
        v10.addNeighbor(v16);
        v10.addNeighbor(v17);
        v10.addNeighbor(v18);
        //Theo dọc
        v10.addNeighbor(v19);
        v10.addNeighbor(v28);
        v10.addNeighbor(v27);
        v10.addNeighbor(v36);
        v10.addNeighbor(v45);
        v10.addNeighbor(v54);
        v10.addNeighbor(v63);
        v10.addNeighbor(v72);
        //Theo khối
        v10.addNeighbor(v2);
        v10.addNeighbor(v3);
        v10.addNeighbor(v20);
        v10.addNeighbor(v21);
        ////////////////////
        //Theo ngang
        v11.addNeighbor(v12);
        v11.addNeighbor(v13);
        v11.addNeighbor(v14);
        v11.addNeighbor(v15);
        v11.addNeighbor(v16);
        v11.addNeighbor(v17);
        v11.addNeighbor(v18);
        //Theo dọc
        v11.addNeighbor(v20);
        v11.addNeighbor(v29);
        v11.addNeighbor(v38);
        v11.addNeighbor(v47);
        v11.addNeighbor(v56);
        v11.addNeighbor(v65);
        v11.addNeighbor(v74);
        //Theo khối
        v11.addNeighbor(v1);
        v11.addNeighbor(v3);
        v11.addNeighbor(v19);
        v11.addNeighbor(v21);
        ////////////////////
        //Theo ngang
        v12.addNeighbor(v13);
        v12.addNeighbor(v14);
        v12.addNeighbor(v15);
        v12.addNeighbor(v16);
        v12.addNeighbor(v17);
        v12.addNeighbor(v18);
        //Theo dọc
        v12.addNeighbor(v21);
        v12.addNeighbor(v30);
        v12.addNeighbor(v39);
        v12.addNeighbor(v48);
        v12.addNeighbor(v57);
        v12.addNeighbor(v66);
        v12.addNeighbor(v75);
        //Theo khối
        v12.addNeighbor(v1);
        v12.addNeighbor(v2);
        v12.addNeighbor(v19);
        v12.addNeighbor(v20);
        ////////////////////
        //Theo ngang
        v13.addNeighbor(v14);
        v13.addNeighbor(v15);
        v13.addNeighbor(v16);
        v13.addNeighbor(v17);
        v13.addNeighbor(v18);
        //Theo dọc
        v13.addNeighbor(v22);
        v13.addNeighbor(v31);
        v13.addNeighbor(v40);
        v13.addNeighbor(v49);
        v13.addNeighbor(v58);
        v13.addNeighbor(v67);
        v13.addNeighbor(v76);
        //Theo khối
        v13.addNeighbor(v5);
        v13.addNeighbor(v6);
        v13.addNeighbor(v23);
        v13.addNeighbor(v24);
        ////////////////////
        //Theo ngang
        v14.addNeighbor(v15);
        v14.addNeighbor(v16);
        v14.addNeighbor(v17);
        v14.addNeighbor(v18);
        //Theo dọc
        v14.addNeighbor(v23);
        v14.addNeighbor(v32);
        v14.addNeighbor(v41);
        v14.addNeighbor(v50);
        v14.addNeighbor(v59);
        v14.addNeighbor(v68);
        v14.addNeighbor(v77);
        //Theo khối
        v14.addNeighbor(v4);
        v14.addNeighbor(v6);
        v14.addNeighbor(v22);
        v14.addNeighbor(v24);
        ////////////////////
        //Theo ngang
        v15.addNeighbor(v16);
        v15.addNeighbor(v17);
        v15.addNeighbor(v18);
        //Theo dọc
        v15.addNeighbor(v24);
        v15.addNeighbor(v33);
        v15.addNeighbor(v42);
        v15.addNeighbor(v51);
        v15.addNeighbor(v60);
        v15.addNeighbor(v69);
        v15.addNeighbor(v78);
        //Theo khối
        v15.addNeighbor(v4);
        v15.addNeighbor(v5);
        v15.addNeighbor(v22);
        v15.addNeighbor(v23);
        ////////////////////
        //Theo ngang
        v16.addNeighbor(v17);
        v16.addNeighbor(v18);
        //Theo dọc
        v16.addNeighbor(v25);
        v16.addNeighbor(v34);
        v16.addNeighbor(v43);
        v16.addNeighbor(v52);
        v16.addNeighbor(v61);
        v16.addNeighbor(v70);
        v16.addNeighbor(v79);
        //Theo khối
        v16.addNeighbor(v8);
        v16.addNeighbor(v9);
        v16.addNeighbor(v26);
        v16.addNeighbor(v27);
        ////////////////////
        //Theo ngang
        v17.addNeighbor(v18);
        //Theo dọc
        v17.addNeighbor(v26);
        v17.addNeighbor(v35);
        v17.addNeighbor(v44);
        v17.addNeighbor(v53);
        v17.addNeighbor(v62);
        v17.addNeighbor(v71);
        v17.addNeighbor(v80);
        //Theo khối
        v17.addNeighbor(v7);
        v17.addNeighbor(v9);
        v17.addNeighbor(v25);
        v17.addNeighbor(v27);
        ////////////////////
        //Theo ngang
        //Theo dọc
        v18.addNeighbor(v27);
        v18.addNeighbor(v36);
        v18.addNeighbor(v45);
        v18.addNeighbor(v54);
        v18.addNeighbor(v63);
        v18.addNeighbor(v72);
        v18.addNeighbor(v81);
        //Theo khối
        v18.addNeighbor(v7);
        v18.addNeighbor(v8);
        v18.addNeighbor(v25);
        v18.addNeighbor(v26);
        ////////////////////
        //Theo ngang
        v19.addNeighbor(v20);
        v19.addNeighbor(v21);
        v19.addNeighbor(v22);
        v19.addNeighbor(v23);
        v19.addNeighbor(v24);
        v19.addNeighbor(v25);
        v19.addNeighbor(v26);
        v19.addNeighbor(v27);
        //Theo dọc
        v19.addNeighbor(v19);
        v19.addNeighbor(v28);
        v19.addNeighbor(v27);
        v19.addNeighbor(v36);
        v19.addNeighbor(v45);
        v19.addNeighbor(v54);
        v19.addNeighbor(v63);
        v19.addNeighbor(v72);
        //Theo khối
        v19.addNeighbor(v2);
        v19.addNeighbor(v3);
        v19.addNeighbor(v12);
        v19.addNeighbor(v11);
        ////////////////////
        //Theo ngang
        v20.addNeighbor(v21);
        v20.addNeighbor(v22);
        v20.addNeighbor(v23);
        v20.addNeighbor(v24);
        v20.addNeighbor(v25);
        v20.addNeighbor(v26);
        v20.addNeighbor(v27);
        //Theo dọc
        v20.addNeighbor(v29);
        v20.addNeighbor(v38);
        v20.addNeighbor(v47);
        v20.addNeighbor(v56);
        v20.addNeighbor(v65);
        v20.addNeighbor(v74);
        //Theo khối
        v20.addNeighbor(v1);
        v20.addNeighbor(v3);
        v20.addNeighbor(v10);
        v20.addNeighbor(v12);
        ////////////////////
        //Theo ngang
        v21.addNeighbor(v22);
        v21.addNeighbor(v23);
        v21.addNeighbor(v24);
        v21.addNeighbor(v25);
        v21.addNeighbor(v26);
        v21.addNeighbor(v27);
        //Theo dọc
        v21.addNeighbor(v30);
        v21.addNeighbor(v39);
        v21.addNeighbor(v48);
        v21.addNeighbor(v57);
        v21.addNeighbor(v66);
        v21.addNeighbor(v75);
        //Theo khối
        v21.addNeighbor(v1);
        v21.addNeighbor(v2);
        v21.addNeighbor(v10);
        v21.addNeighbor(v11);
        ////////////////////
        //Theo ngang
        v22.addNeighbor(v23);
        v22.addNeighbor(v24);
        v22.addNeighbor(v25);
        v22.addNeighbor(v26);
        v22.addNeighbor(v27);
        //Theo dọc
        v22.addNeighbor(v31);
        v22.addNeighbor(v40);
        v22.addNeighbor(v49);
        v22.addNeighbor(v58);
        v22.addNeighbor(v67);
        v22.addNeighbor(v76);
        //Theo khối
        v22.addNeighbor(v5);
        v22.addNeighbor(v6);
        v22.addNeighbor(v14);
        v22.addNeighbor(v15);
        ////////////////////
        //Theo ngang
        v23.addNeighbor(v24);
        v23.addNeighbor(v25);
        v23.addNeighbor(v26);
        v23.addNeighbor(v27);
        //Theo dọc
        v23.addNeighbor(v32);
        v23.addNeighbor(v41);
        v23.addNeighbor(v50);
        v23.addNeighbor(v59);
        v23.addNeighbor(v68);
        v23.addNeighbor(v77);
        //Theo khối
        v23.addNeighbor(v4);
        v23.addNeighbor(v6);
        v23.addNeighbor(v13);
        v23.addNeighbor(v15);
        ////////////////////
        //Theo ngang
        v24.addNeighbor(v25);
        v24.addNeighbor(v26);
        v24.addNeighbor(v27);
        //Theo dọc
        v24.addNeighbor(v33);
        v24.addNeighbor(v42);
        v24.addNeighbor(v51);
        v24.addNeighbor(v60);
        v24.addNeighbor(v69);
        v24.addNeighbor(v78);
        //Theo khối
        v24.addNeighbor(v4);
        v24.addNeighbor(v5);
        v24.addNeighbor(v13);
        v24.addNeighbor(v14);
        ////////////////////
        //Theo ngang
        v25.addNeighbor(v26);
        v25.addNeighbor(v27);
        //Theo dọc
        v25.addNeighbor(v34);
        v25.addNeighbor(v43);
        v25.addNeighbor(v52);
        v25.addNeighbor(v61);
        v25.addNeighbor(v70);
        v25.addNeighbor(v79);
        //Theo khối
        v25.addNeighbor(v8);
        v25.addNeighbor(v9);
        v25.addNeighbor(v17);
        v25.addNeighbor(v28);
        ////////////////////
        //Theo ngang
        v26.addNeighbor(v27);
        //Theo dọc
        v26.addNeighbor(v35);
        v26.addNeighbor(v44);
        v26.addNeighbor(v53);
        v26.addNeighbor(v62);
        v26.addNeighbor(v71);
        v26.addNeighbor(v80);
        //Theo khối
        v26.addNeighbor(v7);
        v26.addNeighbor(v9);
        v26.addNeighbor(v16);
        v26.addNeighbor(v18);
        ////////////////////
        //Theo ngang
        //Theo dọc
        v27.addNeighbor(v36);
        v27.addNeighbor(v45);
        v27.addNeighbor(v54);
        v27.addNeighbor(v63);
        v27.addNeighbor(v72);
        v27.addNeighbor(v81);
        //Theo khối
        v27.addNeighbor(v7);
        v27.addNeighbor(v8);
        v27.addNeighbor(v16);
        v27.addNeighbor(v17);
        ////////////////////
        ////////////////////
        //Theo ngang
        v28.addNeighbor(v29);
        v28.addNeighbor(v30);
        v28.addNeighbor(v31);
        v28.addNeighbor(v32);
        v28.addNeighbor(v33);
        v28.addNeighbor(v34);
        v28.addNeighbor(v35);
        v28.addNeighbor(v36);
        //Theo dọc
        v28.addNeighbor(v37);
        v28.addNeighbor(v46);
        v28.addNeighbor(v55);
        v28.addNeighbor(v64);
        v28.addNeighbor(v73);
        //Theo khối
        v28.addNeighbor(v38);
        v28.addNeighbor(v39);
        v28.addNeighbor(v47);
        v28.addNeighbor(v48);
        ////////////////////
        //Theo ngang
        v29.addNeighbor(v30);
        v29.addNeighbor(v31);
        v29.addNeighbor(v32);
        v29.addNeighbor(v33);
        v29.addNeighbor(v34);
        v29.addNeighbor(v35);
        v29.addNeighbor(v36);
        //Theo dọc
        v29.addNeighbor(v38);
        v29.addNeighbor(v47);
        v29.addNeighbor(v56);
        v29.addNeighbor(v65);
        v29.addNeighbor(v74);
        //Theo khối
        v29.addNeighbor(v37);
        v29.addNeighbor(v39);
        v29.addNeighbor(v46);
        v29.addNeighbor(v48);
        ////////////////////
        //Theo ngang
        v30.addNeighbor(v31);
        v30.addNeighbor(v32);
        v30.addNeighbor(v33);
        v30.addNeighbor(v34);
        v30.addNeighbor(v35);
        v30.addNeighbor(v36);
        //Theo dọc
        v30.addNeighbor(v39);
        v30.addNeighbor(v48);
        v30.addNeighbor(v57);
        v30.addNeighbor(v66);
        v30.addNeighbor(v75);
        //Theo khối
        v30.addNeighbor(v37);
        v30.addNeighbor(v38);
        v30.addNeighbor(v46);
        v30.addNeighbor(v47);
        ////////////////////
        //Theo ngang
        v31.addNeighbor(v32);
        v31.addNeighbor(v33);
        v31.addNeighbor(v34);
        v31.addNeighbor(v35);
        v31.addNeighbor(v36);
        //Theo dọc
        v31.addNeighbor(v40);
        v31.addNeighbor(v49);
        v31.addNeighbor(v58);
        v31.addNeighbor(v67);
        v31.addNeighbor(v76);
        //Theo khối
        v31.addNeighbor(v41);
        v31.addNeighbor(v42);
        v31.addNeighbor(v50);
        v31.addNeighbor(v51);
        ////////////////////
        //Theo ngang
        v32.addNeighbor(v33);
        v32.addNeighbor(v34);
        v32.addNeighbor(v35);
        v32.addNeighbor(v36);
        //Theo dọc
        v32.addNeighbor(v41);
        v32.addNeighbor(v50);
        v32.addNeighbor(v59);
        v32.addNeighbor(v68);
        v32.addNeighbor(v77);
        //Theo khối
        v32.addNeighbor(v40);
        v32.addNeighbor(v42);
        v32.addNeighbor(v49);
        v32.addNeighbor(v51);
        ////////////////////
        //Theo ngang
        v33.addNeighbor(v34);
        v33.addNeighbor(v35);
        v33.addNeighbor(v36);
        //Theo dọc
        v33.addNeighbor(v42);
        v33.addNeighbor(v51);
        v33.addNeighbor(v60);
        v33.addNeighbor(v69);
        v33.addNeighbor(v78);
        //Theo khối
        v33.addNeighbor(v40);
        v33.addNeighbor(v41);
        v33.addNeighbor(v49);
        v33.addNeighbor(v50);
        ////////////////////
        //Theo ngang
        v34.addNeighbor(v35);
        v34.addNeighbor(v36);
        //Theo dọc
        v34.addNeighbor(v43);
        v34.addNeighbor(v52);
        v34.addNeighbor(v61);
        v34.addNeighbor(v70);
        v34.addNeighbor(v79);
        //Theo khối
        v34.addNeighbor(v44);
        v34.addNeighbor(v45);
        v34.addNeighbor(v53);
        v34.addNeighbor(v54);
        ////////////////////
        //Theo ngang
        v35.addNeighbor(v36);
        //Theo dọc
        v35.addNeighbor(v44);
        v35.addNeighbor(v53);
        v35.addNeighbor(v62);
        v35.addNeighbor(v71);
        v35.addNeighbor(v80);
        //Theo khối
        v35.addNeighbor(v43);
        v35.addNeighbor(v45);
        v35.addNeighbor(v52);
        v35.addNeighbor(v54);
        ////////////////////
        //Theo ngang
        //Theo dọc
        v36.addNeighbor(v45);
        v36.addNeighbor(v54);
        v36.addNeighbor(v63);
        v36.addNeighbor(v72);
        v36.addNeighbor(v81);
        //Theo khối
        v36.addNeighbor(v43);
        v36.addNeighbor(v44);
        v36.addNeighbor(v52);
        v36.addNeighbor(v53);
        ////////////////////
        ////////////////////
        //Theo ngang
        v37.addNeighbor(v38);
        v37.addNeighbor(v39);
        v37.addNeighbor(v40);
        v37.addNeighbor(v41);
        v37.addNeighbor(v42);
        v37.addNeighbor(v43);
        v37.addNeighbor(v44);
        v37.addNeighbor(v45);
        //Theo dọc
        v37.addNeighbor(v46);
        v37.addNeighbor(v55);
        v37.addNeighbor(v64);
        v37.addNeighbor(v73);
        //Theo khối
        v37.addNeighbor(v29);
        v37.addNeighbor(v30);
        v37.addNeighbor(v47);
        v37.addNeighbor(v48);
        ////////////////////
        //Theo ngang
        v38.addNeighbor(v39);
        v38.addNeighbor(v40);
        v38.addNeighbor(v41);
        v38.addNeighbor(v42);
        v38.addNeighbor(v43);
        v38.addNeighbor(v44);
        v38.addNeighbor(v45);
        //Theo dọc
        v38.addNeighbor(v47);
        v38.addNeighbor(v56);
        v38.addNeighbor(v65);
        v38.addNeighbor(v74);
        //Theo khối
        v38.addNeighbor(v28);
        v38.addNeighbor(v30);
        v38.addNeighbor(v46);
        v38.addNeighbor(v48);
        ////////////////////
        //Theo ngang
        v39.addNeighbor(v40);
        v39.addNeighbor(v41);
        v39.addNeighbor(v42);
        v39.addNeighbor(v43);
        v39.addNeighbor(v44);
        v39.addNeighbor(v45);
        //Theo dọc
        v39.addNeighbor(v48);
        v39.addNeighbor(v57);
        v39.addNeighbor(v66);
        v39.addNeighbor(v75);
        //Theo khối
        v39.addNeighbor(v28);
        v39.addNeighbor(v29);
        v39.addNeighbor(v46);
        v39.addNeighbor(v47);
        ////////////////////
        //Theo ngang
        v40.addNeighbor(v41);
        v40.addNeighbor(v42);
        v40.addNeighbor(v43);
        v40.addNeighbor(v44);
        v40.addNeighbor(v45);
        //Theo dọc
        v40.addNeighbor(v49);
        v40.addNeighbor(v58);
        v40.addNeighbor(v67);
        v40.addNeighbor(v76);
        //Theo khối
        v40.addNeighbor(v32);
        v40.addNeighbor(v33);
        v40.addNeighbor(v50);
        v40.addNeighbor(v51);
        ////////////////////
        //Theo ngang
        v41.addNeighbor(v42);
        v41.addNeighbor(v43);
        v41.addNeighbor(v44);
        v41.addNeighbor(v45);
        //Theo dọc
        v41.addNeighbor(v50);
        v41.addNeighbor(v59);
        v41.addNeighbor(v68);
        v41.addNeighbor(v77);
        //Theo khối
        v41.addNeighbor(v31);
        v41.addNeighbor(v33);
        v41.addNeighbor(v49);
        v41.addNeighbor(v51);
        ////////////////////
        //Theo ngang
        v42.addNeighbor(v43);
        v42.addNeighbor(v44);
        v42.addNeighbor(v45);
        //Theo dọc
        v42.addNeighbor(v51);
        v42.addNeighbor(v60);
        v42.addNeighbor(v69);
        v42.addNeighbor(v78);
        //Theo khối
        v42.addNeighbor(v31);
        v42.addNeighbor(v32);
        v42.addNeighbor(v49);
        v42.addNeighbor(v50);
        ////////////////////
        //Theo ngang
        v43.addNeighbor(v44);
        v43.addNeighbor(v45);
        //Theo dọc
        v43.addNeighbor(v52);
        v43.addNeighbor(v61);
        v43.addNeighbor(v70);
        v43.addNeighbor(v79);
        //Theo khối
        v43.addNeighbor(v35);
        v43.addNeighbor(v36);
        v43.addNeighbor(v53);
        v43.addNeighbor(v54);
        ////////////////////
        //Theo ngang
        v44.addNeighbor(v45);
        //Theo dọc
        v44.addNeighbor(v53);
        v44.addNeighbor(v62);
        v44.addNeighbor(v71);
        v44.addNeighbor(v80);
        //Theo khối
        v44.addNeighbor(v34);
        v44.addNeighbor(v36);
        v44.addNeighbor(v52);
        v44.addNeighbor(v54);
        ////////////////////
        //Theo ngang
        //Theo dọc
        v45.addNeighbor(v54);
        v45.addNeighbor(v63);
        v45.addNeighbor(v72);
        v45.addNeighbor(v81);
        //Theo khối
        v45.addNeighbor(v34);
        v45.addNeighbor(v35);
        v45.addNeighbor(v52);
        v45.addNeighbor(v53);
        ////////////////////
        ////////////////////
        //Theo ngang
        v46.addNeighbor(v47);
        v46.addNeighbor(v48);
        v46.addNeighbor(v49);
        v46.addNeighbor(v50);
        v46.addNeighbor(v51);
        v46.addNeighbor(v52);
        v46.addNeighbor(v53);
        v46.addNeighbor(v54);
        //Theo dọc
        v46.addNeighbor(v55);
        v46.addNeighbor(v64);
        v46.addNeighbor(v73);
        //Theo khối
        v46.addNeighbor(v29);
        v46.addNeighbor(v30);
        v46.addNeighbor(v38);
        v46.addNeighbor(v39);
        ////////////////////
        //Theo ngang
        v47.addNeighbor(v48);
        v47.addNeighbor(v49);
        v47.addNeighbor(v50);
        v47.addNeighbor(v51);
        v47.addNeighbor(v52);
        v47.addNeighbor(v53);
        v47.addNeighbor(v54);
        //Theo dọc
        v47.addNeighbor(v56);
        v47.addNeighbor(v65);
        v47.addNeighbor(v74);
        //Theo khối
        v47.addNeighbor(v28);
        v47.addNeighbor(v30);
        v47.addNeighbor(v37);
        v47.addNeighbor(v39);
        ////////////////////
        //Theo ngang
        v48.addNeighbor(v49);
        v48.addNeighbor(v50);
        v48.addNeighbor(v51);
        v48.addNeighbor(v52);
        v48.addNeighbor(v53);
        v48.addNeighbor(v54);
        //Theo dọc
        v48.addNeighbor(v57);
        v48.addNeighbor(v66);
        v48.addNeighbor(v75);
        //Theo khối
        v48.addNeighbor(v28);
        v48.addNeighbor(v29);
        v48.addNeighbor(v37);
        v48.addNeighbor(v38);
        ////////////////////
        //Theo ngang
        v49.addNeighbor(v50);
        v49.addNeighbor(v51);
        v49.addNeighbor(v52);
        v49.addNeighbor(v53);
        v49.addNeighbor(v54);
        //Theo dọc
        v49.addNeighbor(v58);
        v49.addNeighbor(v67);
        v49.addNeighbor(v76);
        //Theo khối
        v49.addNeighbor(v32);
        v49.addNeighbor(v33);
        v49.addNeighbor(v41);
        v49.addNeighbor(v42);
        ////////////////////
        //Theo ngang
        v50.addNeighbor(v51);
        v50.addNeighbor(v52);
        v50.addNeighbor(v53);
        v50.addNeighbor(v54);
        //Theo dọc
        v50.addNeighbor(v59);
        v50.addNeighbor(v68);
        v50.addNeighbor(v77);
        //Theo khối
        v50.addNeighbor(v31);
        v50.addNeighbor(v33);
        v50.addNeighbor(v40);
        v50.addNeighbor(v42);
        ////////////////////
        //Theo ngang
        v51.addNeighbor(v52);
        v51.addNeighbor(v53);
        v51.addNeighbor(v54);
        //Theo dọc
        v51.addNeighbor(v60);
        v51.addNeighbor(v69);
        v51.addNeighbor(v78);
        //Theo khối
        v51.addNeighbor(v31);
        v51.addNeighbor(v32);
        v51.addNeighbor(v40);
        v51.addNeighbor(v41);
        ////////////////////
        //Theo ngang
        v52.addNeighbor(v53);
        v52.addNeighbor(v54);
        //Theo dọc
        v52.addNeighbor(v61);
        v52.addNeighbor(v70);
        v52.addNeighbor(v79);
        //Theo khối
        v52.addNeighbor(v35);
        v52.addNeighbor(v36);
        v52.addNeighbor(v44);
        v52.addNeighbor(v45);
        ////////////////////
        //Theo ngang
        v53.addNeighbor(v54);
        //Theo dọc
        v53.addNeighbor(v62);
        v53.addNeighbor(v71);
        v53.addNeighbor(v80);
        //Theo khối
        v53.addNeighbor(v34);
        v53.addNeighbor(v36);
        v53.addNeighbor(v43);
        v53.addNeighbor(v45);
        ////////////////////
        //Theo ngang
        //Theo dọc
        v54.addNeighbor(v63);
        v54.addNeighbor(v72);
        v54.addNeighbor(v81);
        //Theo khối
        v54.addNeighbor(v34);
        v54.addNeighbor(v35);
        v54.addNeighbor(v43);
        v54.addNeighbor(v44);
        ////////////////////
        ////////////////////
        //Theo ngang
        v55.addNeighbor(v56);
        v55.addNeighbor(v57);
        v55.addNeighbor(v58);
        v55.addNeighbor(v59);
        v55.addNeighbor(v60);
        v55.addNeighbor(v61);
        v55.addNeighbor(v62);
        v55.addNeighbor(v63);
        //Theo dọc
        v55.addNeighbor(v64);
        v55.addNeighbor(v73);
        //Theo khối
        v55.addNeighbor(v65);
        v55.addNeighbor(v66);
        v55.addNeighbor(v74);
        v55.addNeighbor(v75);
        ////////////////////
        //Theo ngang
        v56.addNeighbor(v57);
        v56.addNeighbor(v58);
        v56.addNeighbor(v59);
        v56.addNeighbor(v60);
        v56.addNeighbor(v61);
        v56.addNeighbor(v62);
        v56.addNeighbor(v63);
        //Theo dọc
        v56.addNeighbor(v65);
        v56.addNeighbor(v74);
        //Theo khối
        v56.addNeighbor(v64);
        v56.addNeighbor(v66);
        v56.addNeighbor(v73);
        v56.addNeighbor(v75);
        ////////////////////
        //Theo ngang
        v57.addNeighbor(v58);
        v57.addNeighbor(v59);
        v57.addNeighbor(v60);
        v57.addNeighbor(v61);
        v57.addNeighbor(v62);
        v57.addNeighbor(v63);
        //Theo dọc
        v57.addNeighbor(v66);
        v57.addNeighbor(v75);
        //Theo khối
        v57.addNeighbor(v64);
        v57.addNeighbor(v65);
        v57.addNeighbor(v73);
        v57.addNeighbor(v74);
        ////////////////////
        //Theo ngang
        v58.addNeighbor(v59);
        v58.addNeighbor(v60);
        v58.addNeighbor(v61);
        v58.addNeighbor(v62);
        v58.addNeighbor(v63);
        //Theo dọc
        v58.addNeighbor(v67);
        v58.addNeighbor(v76);
        //Theo khối
        v58.addNeighbor(v68);
        v58.addNeighbor(v69);
        v58.addNeighbor(v77);
        v58.addNeighbor(v78);
        ////////////////////
        //Theo ngang
        v59.addNeighbor(v60);
        v59.addNeighbor(v61);
        v59.addNeighbor(v62);
        v59.addNeighbor(v63);
        //Theo dọc
        v59.addNeighbor(v68);
        v59.addNeighbor(v77);
        //Theo khối
        v59.addNeighbor(v67);
        v59.addNeighbor(v69);
        v59.addNeighbor(v76);
        v59.addNeighbor(v78);
        ////////////////////
        //Theo ngang
        v60.addNeighbor(v61);
        v60.addNeighbor(v62);
        v60.addNeighbor(v63);
        //Theo dọc
        v60.addNeighbor(v69);
        v60.addNeighbor(v78);
        //Theo khối
        v60.addNeighbor(v67);
        v60.addNeighbor(v68);
        v60.addNeighbor(v76);
        v60.addNeighbor(v77);
        ////////////////////
        //Theo ngang
        v61.addNeighbor(v62);
        v61.addNeighbor(v63);
        //Theo dọc
        v61.addNeighbor(v70);
        v61.addNeighbor(v79);
        //Theo khối
        v61.addNeighbor(v71);
        v61.addNeighbor(v72);
        v61.addNeighbor(v80);
        v61.addNeighbor(v81);
        ////////////////////
        //Theo ngang
        v62.addNeighbor(v63);
        //Theo dọc
        v62.addNeighbor(v71);
        v62.addNeighbor(v80);
        //Theo khối
        v62.addNeighbor(v70);
        v62.addNeighbor(v72);
        v62.addNeighbor(v79);
        v62.addNeighbor(v81);
        ////////////////////
        //Theo ngang
        //Theo dọc
        v63.addNeighbor(v72);
        v63.addNeighbor(v81);
        //Theo khối
        v63.addNeighbor(v70);
        v63.addNeighbor(v71);
        v63.addNeighbor(v79);
        v63.addNeighbor(v80);
        ////////////////////
        ////////////////////
        //Theo ngang
        v64.addNeighbor(v65);
        v64.addNeighbor(v66);
        v64.addNeighbor(v67);
        v64.addNeighbor(v68);
        v64.addNeighbor(v69);
        v64.addNeighbor(v70);
        v64.addNeighbor(v71);
        v64.addNeighbor(v72);
        //Theo dọc
        v64.addNeighbor(v73);
        //Theo khối
        v64.addNeighbor(v56);
        v64.addNeighbor(v57);
        v64.addNeighbor(v74);
        v64.addNeighbor(v75);
        ////////////////////
        //Theo ngang
        v65.addNeighbor(v66);
        v65.addNeighbor(v67);
        v65.addNeighbor(v68);
        v65.addNeighbor(v69);
        v65.addNeighbor(v70);
        v65.addNeighbor(v71);
        v65.addNeighbor(v72);
        //Theo dọc
        v65.addNeighbor(v74);
        //Theo khối
        v65.addNeighbor(v55);
        v65.addNeighbor(v57);
        v65.addNeighbor(v73);
        v65.addNeighbor(v75);
        ////////////////////
        //Theo ngang
        v66.addNeighbor(v67);
        v66.addNeighbor(v68);
        v66.addNeighbor(v69);
        v66.addNeighbor(v70);
        v66.addNeighbor(v71);
        v66.addNeighbor(v72);
        //Theo dọc
        v66.addNeighbor(v75);
        //Theo khối
        v66.addNeighbor(v55);
        v66.addNeighbor(v56);
        v66.addNeighbor(v73);
        v66.addNeighbor(v74);
        ////////////////////
        //Theo ngang
        v67.addNeighbor(v68);
        v67.addNeighbor(v69);
        v67.addNeighbor(v70);
        v67.addNeighbor(v71);
        v67.addNeighbor(v72);
        //Theo dọc
        v67.addNeighbor(v76);
        //Theo khối
        v67.addNeighbor(v59);
        v67.addNeighbor(v60);
        v67.addNeighbor(v77);
        v67.addNeighbor(v78);
        ////////////////////
        //Theo ngang
        v68.addNeighbor(v69);
        v68.addNeighbor(v70);
        v68.addNeighbor(v71);
        v68.addNeighbor(v72);
        //Theo dọc
        v68.addNeighbor(v77);
        //Theo khối
        v68.addNeighbor(v58);
        v68.addNeighbor(v60);
        v68.addNeighbor(v76);
        v68.addNeighbor(v78);
        ////////////////////
        //Theo ngang
        v69.addNeighbor(v70);
        v69.addNeighbor(v71);
        v69.addNeighbor(v72);
        //Theo dọc
        v69.addNeighbor(v78);
        //Theo khối
        v69.addNeighbor(v58);
        v69.addNeighbor(v59);
        v69.addNeighbor(v76);
        v69.addNeighbor(v77);
        ////////////////////
        //Theo ngang
        v70.addNeighbor(v71);
        v70.addNeighbor(v72);
        //Theo dọc
        v70.addNeighbor(v79);
        //Theo khối
        v70.addNeighbor(v62);
        v70.addNeighbor(v63);
        v70.addNeighbor(v80);
        v70.addNeighbor(v81);
        ////////////////////
        //Theo ngang
        v71.addNeighbor(v72);
        //Theo dọc
        v71.addNeighbor(v80);
        //Theo khối
        v71.addNeighbor(v61);
        v71.addNeighbor(v63);
        v71.addNeighbor(v79);
        v71.addNeighbor(v81);
        ////////////////////
        //Theo ngang
        //Theo dọc
        v72.addNeighbor(v81);
        //Theo khối
        v72.addNeighbor(v61);
        v72.addNeighbor(v62);
        v72.addNeighbor(v79);
        v72.addNeighbor(v80);
        ////////////////////
        ////////////////////
        //Theo ngang
        v73.addNeighbor(v74);
        v73.addNeighbor(v75);
        v73.addNeighbor(v76);
        v73.addNeighbor(v77);
        v73.addNeighbor(v78);
        v73.addNeighbor(v79);
        v73.addNeighbor(v80);
        v73.addNeighbor(v81);
        //Theo dọc
        //Theo khối
        v73.addNeighbor(v56);
        v73.addNeighbor(v57);
        v73.addNeighbor(v65);
        v73.addNeighbor(v66);
        ////////////////////
        //Theo ngang
        v74.addNeighbor(v75);
        v74.addNeighbor(v76);
        v74.addNeighbor(v77);
        v74.addNeighbor(v78);
        v74.addNeighbor(v79);
        v74.addNeighbor(v80);
        v74.addNeighbor(v81);
        //Theo dọc
        //Theo khối
        v74.addNeighbor(v55);
        v74.addNeighbor(v57);
        v74.addNeighbor(v64);
        v74.addNeighbor(v66);
        ////////////////////
        //Theo ngang
        v75.addNeighbor(v76);
        v75.addNeighbor(v77);
        v75.addNeighbor(v78);
        v75.addNeighbor(v79);
        v75.addNeighbor(v80);
        v75.addNeighbor(v81);
        //Theo dọc
        //Theo khối
        v75.addNeighbor(v55);
        v75.addNeighbor(v56);
        v75.addNeighbor(v64);
        v75.addNeighbor(v65);
        ////////////////////
        //Theo ngang
        v76.addNeighbor(v77);
        v76.addNeighbor(v78);
        v76.addNeighbor(v79);
        v76.addNeighbor(v80);
        v76.addNeighbor(v81);
        //Theo dọc
        //Theo khối
        v76.addNeighbor(v59);
        v76.addNeighbor(v60);
        v76.addNeighbor(v68);
        v76.addNeighbor(v69);
        ////////////////////
        //Theo ngang
        v77.addNeighbor(v78);
        v77.addNeighbor(v79);
        v77.addNeighbor(v80);
        v77.addNeighbor(v81);
        //Theo dọc
        //Theo khối
        v77.addNeighbor(v58);
        v77.addNeighbor(v60);
        v77.addNeighbor(v67);
        v77.addNeighbor(v69);
        ////////////////////
        //Theo ngang
        v78.addNeighbor(v79);
        v78.addNeighbor(v80);
        v78.addNeighbor(v81);
        //Theo dọc
        //Theo khối
        v78.addNeighbor(v58);
        v78.addNeighbor(v59);
        v78.addNeighbor(v67);
        v78.addNeighbor(v68);
        ////////////////////
        //Theo ngang
        v79.addNeighbor(v80);
        v79.addNeighbor(v81);
        //Theo dọc
        //Theo khối
        v79.addNeighbor(v62);
        v79.addNeighbor(v63);
        v79.addNeighbor(v71);
        v79.addNeighbor(v72);
        ////////////////////
        //Theo ngang
        v80.addNeighbor(v81);
        //Theo dọc
        //Theo khối
        v80.addNeighbor(v61);
        v80.addNeighbor(v63);
        v80.addNeighbor(v70);
        v80.addNeighbor(v72);
        ////////////////////
        //Theo ngang
        //Theo dọc
        //Theo khối
        v81.addNeighbor(v61);
        v81.addNeighbor(v62);
        v81.addNeighbor(v70);
        v81.addNeighbor(v71);
        ////////////////////
        this.insertVertex(v1);
        this.insertVertex(v2);
        this.insertVertex(v3);
        this.insertVertex(v4);
        this.insertVertex(v5);
        this.insertVertex(v6);
        this.insertVertex(v7);
        this.insertVertex(v8);
        this.insertVertex(v9);
        this.insertVertex(v10);
        this.insertVertex(v11);
        this.insertVertex(v12);
        this.insertVertex(v13);
        this.insertVertex(v14);
        this.insertVertex(v15);
        this.insertVertex(v16);
        this.insertVertex(v17);
        this.insertVertex(v18);
        this.insertVertex(v19);
        this.insertVertex(v20);
        this.insertVertex(v21);
        this.insertVertex(v22);
        this.insertVertex(v23);
        this.insertVertex(v24);
        this.insertVertex(v25);
        this.insertVertex(v26);
        this.insertVertex(v27);
        this.insertVertex(v28);
        this.insertVertex(v29);
        this.insertVertex(v30);
        this.insertVertex(v31);
        this.insertVertex(v32);
        this.insertVertex(v33);
        this.insertVertex(v34);
        this.insertVertex(v35);
        this.insertVertex(v36);
        this.insertVertex(v37);
        this.insertVertex(v38);
        this.insertVertex(v39);
        this.insertVertex(v40);
        this.insertVertex(v41);
        this.insertVertex(v42);
        this.insertVertex(v43);
        this.insertVertex(v44);
        this.insertVertex(v45);
        this.insertVertex(v46);
        this.insertVertex(v47);
        this.insertVertex(v48);
        this.insertVertex(v49);
        this.insertVertex(v50);
        this.insertVertex(v51);
        this.insertVertex(v52);
        this.insertVertex(v53);
        this.insertVertex(v54);
        this.insertVertex(v55);
        this.insertVertex(v56);
        this.insertVertex(v57);
        this.insertVertex(v58);
        this.insertVertex(v59);
        this.insertVertex(v60);
        this.insertVertex(v61);
        this.insertVertex(v62);
        this.insertVertex(v63);
        this.insertVertex(v64);
        this.insertVertex(v65);
        this.insertVertex(v66);
        this.insertVertex(v67);
        this.insertVertex(v68);
        this.insertVertex(v69);
        this.insertVertex(v70);
        this.insertVertex(v71);
        this.insertVertex(v72);
        this.insertVertex(v73);
        this.insertVertex(v74);
        this.insertVertex(v75);
        this.insertVertex(v76);
        this.insertVertex(v77);
        this.insertVertex(v78);
        this.insertVertex(v79);
        this.insertVertex(v80);
        this.insertVertex(v81);
    }
    public void clear(){
        listVertex = new ArrayList<>();
        listEdge = new ArrayList<>();
        graphMatrix = null;
    }
}
