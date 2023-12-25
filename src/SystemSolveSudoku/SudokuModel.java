package SystemSolveSudoku;


public class SudokuModel {
	GraphService graphService;

	public GenerateGraph getGraphSV(){
		return graphService.getLastGraph();
	}
	public SudokuModel() {
		graphService = new GraphService();
	}
	public void makeNewGame() {
		graphService.makeNewGame();
	}

	public void makeNewGame2(int level){
		graphService.makeNewGame2(level);
	}
	public GenerateGraph getSolved() {
		return graphService.getLastGraph();
	}
	public boolean isSuccess() {
		return graphService.isRefreshGame();
	}
	public static void main(String[] args) {
		SudokuModel s = new SudokuModel();
		s.makeNewGame();
	}
}
