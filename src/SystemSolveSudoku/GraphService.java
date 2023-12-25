package SystemSolveSudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class GraphService {

	//lastGraphSV là
	protected GenerateGraph lastGenerateGraph = new GenerateGraph();
	public int[][] board = new int[9][9];
	static final int SIZE = 9;
	static Random r = new Random();
	boolean refreshGame = true;

	Graph graph;
	public GraphService() {


	}
	// Check xem nó có thể nằm ở hàng đó không
	private boolean isInRow(int row, int number) {
		for (int i = 0; i < SIZE; i++)
			if (lastGenerateGraph.getMatrix()[row][i] == number)
				return true;
		return false;
	}

	// Check xem nó có thể nằm cột đó không
	private boolean isInCol(int col, int number) {
		for (int i = 0; i < SIZE; i++)
			if (lastGenerateGraph.getMatrix()[i][col] == number)
				return true;

		return false;
	}
	//Kiểm tra xem số đó có thể nằm trong ô ma trận 3x3 này ko
	private boolean isInBox(int row, int col, int number) {
		int r = row - row % 3;
		int c = col - col % 3;

		for (int i = r; i < r + 3; i++)
			for (int j = c; j < c + 3; j++)
				if (lastGenerateGraph.getMatrix()[i][j] == number)
					return true;
		return false;
	}

	// Check cả 3 điều kiện ta được 1 ô đặt đúng số
	private boolean isOk(int row, int col, int number) {
		return !isInRow(row, number) && !isInCol(col, number) && !isInBox(row, col, number);
	}


	//Tô màu đỉnh đồ thị + quay lui
	public boolean solve2(){
		int[][] matrix = lastGenerateGraph.getMatrix(); //Lấy dữ liệu số từ màn hình
		graph = new Graph(lastGenerateGraph.getMatrix());
		graph.init(); //Tạo ra đồ thị 81 đỉnh
		Vertex[] cells = graph.getCells(); //Lấy ra 81 đỉnh
		for(int i=0;i< cells.length;i++){
			if(cells[i].getValue() == 0){ //Kiểm tra xem đỉnh nào = 0
				ArrayList<Integer> listNumber = new ArrayList<>();
				int[] check = new int[10]; //Mảng đánh dấu xem số nào đã xuất hiện rồi (Thay vì dùng remove) => Hiệu quả hơn
				for(int j=1;j<=9;j++){
					listNumber.add(j); //Thêm các số từ 1-9
				}
				ArrayList<Vertex> listNeighbor = graph.listVertex().get(i).getNeighbor(); // Lấy các đỉnh ràng buộc chung
				//Loại dần màu sắc
				for(Vertex v : listNeighbor){
					if(listNumber.contains(v.getValue())){
						check[v.getValue()] = 1;
					}
				}
				//Tiến hành check xem số màu còn lại màu nào khả thi
				int cot = i % 9; //Lấy column của đỉnh
				int hang = i / 9; //Lấy row của đỉnh
				for(int j=1;j<=9;j++){
					if(check[j] == 0){ //Sau khi lọc các số còn lại các số thỏa mãn ta tiến hành kiểm tra xem đặt nó vào có ok ko
						if(isInRow(hang,j) == false && isInCol(cot,j) == false && isInBox(hang,cot,j) == false){
							lastGenerateGraph.getMatrix()[hang][cot] = j; //OK thì đặt vào đây
							graph.listVertex().get(i).setValue(j); //Chỉnh lại giá trị trong đồ thị
							if(solve2()){ // quay lui
								return true;
							}else{ //Nếu ko giải được thì cho bằng 0 để quay lui xử lý
								lastGenerateGraph.getMatrix()[hang][cot] = 0;
							}
						}
					}
				}
				return false;
			}
		}
		return true;
	}

	public boolean solve() {
		//Tô màu + Backtracking
		return solve2();
	}



	public ArrayList<int[][]> listEasyLevel = new ArrayList<>();
	public ArrayList<int[][]> listMediumLevel = new ArrayList<>();
	public ArrayList<int[][]> listHardLevel = new ArrayList<>();
	public void inputData(){
		Scanner input = null;
		try {
			int i=0;
			int[][] matrixInput = new int[9][9];
			input = new Scanner(new File("C:\\Users\\AlarmTran\\IdeaProjects\\Lab\\src\\Level_Template\\easy1.txt"));
			while(input.hasNext()){
				String content = input.nextLine();
				if(content.length() == 1){
					listEasyLevel.add(matrixInput);
					input.nextLine();
					i=0;
				}else{
					matrixInput = new int[9][9];
					String[] line = content.split("\\s");
					for(int j=0;j<9;j++){
						matrixInput[i][j] = Integer.parseInt(line[j]);
					}
					i++;
				}
			}
			i=0;
			input = new Scanner(new File("C:\\Users\\AlarmTran\\IdeaProjects\\Lab\\src\\Level_Template\\medium1.txt"));
			while(input.hasNext()){
				String content = input.nextLine();
				if(content.length() == 1){
					listMediumLevel.add(matrixInput);
					input.nextLine();
					i=0;
				}else{
					matrixInput = new int[9][9];
					String[] line = content.split("\\s");
					for(int j=0;j<9;j++){
						matrixInput[i][j] = Integer.parseInt(line[j]);
					}
					i++;
				}
			}
			i=0;
			input = new Scanner(new File("C:\\Users\\AlarmTran\\IdeaProjects\\Lab\\src\\Level_Template\\hard1.txt"));
			while(input.hasNext()){
				String content = input.nextLine();
				if(content.length() == 1){
					listHardLevel.add(matrixInput);
					input.nextLine();
					i=0;
				}else{
					matrixInput = new int[9][9];
					String[] line = content.split("\\s");
					for(int j=0;j<9;j++){
						matrixInput[i][j] = Integer.parseInt(line[j]);
					}
					i++;
				}
			}

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	protected ArrayList<GenerateGraph> generateGraphs = new ArrayList<GenerateGraph>();
	protected ArrayList<GenerateGraph> generateGraphReproducers = new ArrayList<GenerateGraph>();
	protected ArrayList<GenerateGraph> generateGraphResults = new ArrayList<GenerateGraph>();
	protected ArrayList<GenerateGraph> generateGraphFamily = new ArrayList<GenerateGraph>();



	public GenerateGraph getLastGraph() {
		return lastGenerateGraph;
	}

	public void makeNewGame() {
		inputData();
		int[][] lastState = lastGenerateGraph.getMatrix();
		makeProblem(lastState);
		solveGame();
	}
	public void makeNewGame2(int choice){
		lastGenerateGraph.makeNewGame2(choice);
		solveGame();
	}

	public void display2(int board[][]) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(" " + board[i][j]);
			}

			System.out.println();
		}

		System.out.println();
	}

	
	
	
	
	public void solveGame() {
		if (solve()) {
			System.out.println("Tạo Thành công");
			display2(lastGenerateGraph.getMatrix());
			refreshGame =true;
		}else{
			System.out.println("Tạo Thất Bại");
			display2(lastGenerateGraph.getMatrix());
			refreshGame =false;
		}
		generateGraphFamily.clear();
		generateGraphResults.clear();
		generateGraphReproducers.clear();
		generateGraphs.clear();
	}
	public boolean isRefreshGame() {
		return refreshGame;
	}

	//Tạo độ khó
	public void makeProblem(int[][] state) {
		for (int k = 0; k < 9; k++) {
			for (int i = 0; i < 9; i++) {
				if (i < 8) {
					for (int j = i + 1; j < 9; j++) {
						if (state[k][i] == state[k][j]) {
							state[k][i] = 0;
						}
					}
				}
			}
		}
		for (int k = 0; k < 9; k++) {
			for (int i = 0; i < 9; i++) {
				if (i < 8) {
					for (int j = i + 1; j < 9; j++) {
						if (state[i][k] == state[j][k]) {
							state[i][k] = 0;
						}
					}
				}
			}
		}
		for (int l = 0; l < 5; l++) {
			for (int k = 0; k < 9; k++) {
				int i = 1 + r.nextInt(8);
				state[k][i] = 0;
			}
			for (int k = 0; k < 9; k++) {
				int i = 1 + r.nextInt(8);
				state[i][k] = 0;
			}
		}
	}


}
