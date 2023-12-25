package SystemSolveSudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;


//ĐỒ THỊ
public class GenerateGraph implements Comparable<GenerateGraph> {
	int matrix[][] = new int[9][9];
	static Random random = new Random();
	public long length;
	public float currentScore = 0.0f;

	//Điểm đánh giá một ma trận có phải ma trận Sudoku hay không là currentScore
	//Tối đa là 1000 điểm min là 0 điểm
	int theMin = 0;
	int theMax = 1000;
	HashSet<Integer> rowMap = new HashSet<Integer>(); //Các phần tử theo hàng
	HashSet<Integer> columnMap = new HashSet<Integer>(); //Các phn tử theo cột
	HashSet<Integer> squareMap = new HashSet<Integer>(); //Các phần tử theo ô

	public ArrayList<int[][]> listEasyLevel = new ArrayList<>();
	public ArrayList<int[][]> listMediumLevel = new ArrayList<>();
	public ArrayList<int[][]> listHardLevel = new ArrayList<>();

	//so sánh độ phù hợp của 2 ma trận dựa trên điểm của nó
	@Override
	public int compareTo(GenerateGraph o) {
		if (this.currentScore < o.currentScore)
			return 1;
		else if (this.currentScore > o.currentScore)
			return -1;
		else
			return 0;
	}

	public GenerateGraph() {

	}

	public GenerateGraph(long length, int min, int max) {
		this.length = length;
		this.theMax = max;
		this.theMin = min;
		//Sinh ma trận 9x9 các số từ 1-9
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.matrix[i][j] = 1+random.nextInt(8);
			}
		}
	}

	public void shuffle() {
		int mutationIndex1 = random.nextInt(9);
		int mutationIndex2 = random.nextInt(9);
		int mutationIndex3 = random.nextInt(9);
		if (random.nextInt(2) == 1) {
			this.matrix[mutationIndex1][mutationIndex2] = mutationIndex3 + 1;
		} else {
			int temp = 0;
			if (random.nextInt(2) == 1) {
				temp = this.matrix[mutationIndex1][mutationIndex2];
				this.matrix[mutationIndex1][mutationIndex2] = this.matrix[mutationIndex3][mutationIndex2];
				this.matrix[mutationIndex3][mutationIndex2] = temp;
			} else {
				temp = this.matrix[mutationIndex2][mutationIndex1];
				this.matrix[mutationIndex2][mutationIndex1] = this.matrix[mutationIndex2][mutationIndex3];
				this.matrix[mutationIndex2][mutationIndex3] = temp;
			}
		}
	}

	public int[][] getMatrix() {
		return matrix;
	}


	public void copy(GenerateGraph g) {
		GenerateGraph generateGraph = g;
		generateGraph.length = length;
		generateGraph.theMin = theMin;
		generateGraph.theMax = theMax;
	}
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
					matrixInput = new int[9][9];
				}else{
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
					matrixInput = new int[9][9];
				}else{

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
					matrixInput = new int[9][9];
				}else{
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
	public void makeNewGame2(int level){
		inputData();
		switch (level){
			case 0:
				int random = new Random().nextInt(listEasyLevel.size());
				matrix = listEasyLevel.get(random);
				shuffle();
				break;
			case 1:
				int random1 = new Random().nextInt(listMediumLevel.size());
				matrix = listMediumLevel.get(random1);
				break;
			case 2:
				int random2 = new Random().nextInt(listHardLevel.size());
				matrix = listHardLevel.get(random2);
				break;
		}
	}
}
