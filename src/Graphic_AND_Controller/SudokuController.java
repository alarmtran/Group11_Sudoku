package Graphic_AND_Controller;

import SystemSolveSudoku.SudokuModel;
import Views.SudokuGame;

public class SudokuController implements Controller {
	SudokuModel model;
	SudokuGame view;
	public SudokuController (SudokuModel model) {
		this.model = model;
		view = new SudokuGame(this, model);
	}
	@Override
	public void makeNewGame() {
		model.makeNewGame();
	}

	@Override
	public void makeNewGame2(int level) {
		model.makeNewGame2(level);
	}


}