package Client;

import Graphic_AND_Controller.Controller;
import Graphic_AND_Controller.SudokuController;
import SystemSolveSudoku.SudokuModel;

public class Start {
	public static void main(String[] args) {
		SudokuModel model =new SudokuModel();
		Controller controller = new SudokuController(model);
	}
}
