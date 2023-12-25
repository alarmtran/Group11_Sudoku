package Views;

import Graphic_AND_Controller.Controller;
import Graphic_AND_Controller.GraphicBoard;
import SystemSolveSudoku.Graph;
import SystemSolveSudoku.SudokuModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SudokuGame extends JFrame implements ActionListener {
	JTextField[][] board = new JTextField[9][9];
	int[][] matrix = new int[9][9];
	int[][] solvedMatrix = new int[9][9];
	int numberCellIllegal = 0;
	JButton jbNew, jbSolved, jbCheck;
	JButton lbMessage;
	JComboBox<String> comboBox;
	Controller controller;
	SudokuModel model;
	Random random = new Random();
	boolean reset = true;
	Font font = new Font("Arial", Font.BOLD, 16);
	ColorUIResource colorMain = new ColorUIResource(116, 96, 24);
	Color colorButton = new Color(86, 134, 86);
	Color colorOpacity = new Color(144, 202, 108);
	ColorUIResource colorCell = new ColorUIResource(178, 231, 250);
	ColorUIResource colorText = new ColorUIResource(255, 51, 51);
	Color colorSolved = new Color(255, 221, 221);

	Graph graph;

	public SudokuGame(Controller controller, SudokuModel model) {
		this.controller = controller;
		this.model = model;
		init();
	}

	public SudokuGame() {

	}

	public void init() {
		setTitle("Sudoku Game");
		setSize(700, 500);
		createView();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void createView() {
		JPanel container = new JPanel();
		add(container);
		container.setLayout(new BorderLayout());
		JLayeredPane boardPanel = new GraphicBoard(new GridLayout(9, 9, 2, 2));
		JPanel controlPanel = new JPanel(new BorderLayout());
		controlPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		controlPanel.setBackground(Color.white);
		boardPanel.setBorder(new LineBorder(colorMain, 5));
		container.add(boardPanel, BorderLayout.CENTER);
		container.add(controlPanel, BorderLayout.EAST);

		//
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				board[i][j] = new JTextField();
				board[i][j].addActionListener(this);
				board[i][j].setHorizontalAlignment(JTextField.CENTER);
				
				board[i][j].setBorder(new LineBorder(colorMain, 1));
				board[i][j].setFont(new Font("Arial", Font.BOLD, 25));
				board[i][j].setForeground(colorText);

				boardPanel.add(board[i][j]);

			}
		}
		//

		comboBox = new JComboBox<String>(new String[] { "Dễ", "Trung Bình", "Khó" });
		comboBox.setPreferredSize(new DimensionUIResource(110, 20));
		comboBox.setBackground(colorMain);
		comboBox.setForeground(Color.white);
		comboBox.setOpaque(true);

		JLabel label = new JLabel("Độ khó: ");
		JPanel headerPanel = new JPanel();
		headerPanel.add(label);
		headerPanel.add(comboBox);
		headerPanel.setBackground(Color.white);
		headerPanel.setBorder(new LineBorder(colorMain, 2));

		jbNew = new JButton("Trò chơi mới");
		jbNew.addActionListener(this);
		setUI(jbNew);
		setHover(jbNew);

		jbSolved = new JButton("Giải");
		setUI(jbSolved);
		setHover(jbSolved);
		jbSolved.addActionListener(this);

		jbCheck = new JButton("Kiểm tra");
		setUI(jbCheck);
		setHover(jbCheck);
		jbCheck.addActionListener(this);
		JPanel panelBt = new JPanel();
		panelBt.setPreferredSize(new DimensionUIResource(200, 140));
//		BoxLayout boxLayout = new BoxLayout(panelBt, BoxLayout.Y_AXIS);
		panelBt.setLayout(new GridLayout(4, 1, 5, 5));
		panelBt.add(headerPanel);

		panelBt.add(jbNew);
		panelBt.add(jbSolved);
		panelBt.add(jbCheck);
		lbMessage = new JButton("Hãy tạo trò chơi mới");
		JButton lbTitle = new JButton("Sudoku Game");
		lbTitle.setBackground(Color.white);
		lbTitle.setBorder(null);
		lbTitle.setEnabled(true);
		lbTitle.setFont(new Font("Arial", Font.BOLD, 25));
		lbTitle.setForeground(colorMain);
		lbMessage.setFont(new Font("Arial", Font.BOLD, 15));
		lbMessage.setBackground(Color.pink);
		lbMessage.setBorder(null);
		lbMessage.setEnabled(true);
		JPanel panelInfo = new JPanel();
		panelInfo.add(lbTitle);
		panelInfo.add(lbMessage);
		panelInfo.setBorder(new LineBorder(colorMain,2));
		panelInfo.setLayout(new GridLayout(7, 1, 10, 10));
		

		panelInfo.setBackground(Color.white);
		
		
		controlPanel.add(panelInfo,BorderLayout.CENTER);
		controlPanel.add(panelBt,BorderLayout.NORTH);

	}

	public void setUI(JComponent component) {
		component.setBackground(colorButton);
		component.setForeground(Color.white);
		component.setFont(font);
		component.setCursor(new Cursor(Cursor.HAND_CURSOR));
		component.setBorder(null);

	}

	public void setHover(JComponent component) {
		component.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				component.setBackground(colorOpacity);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				component.setBackground(colorButton);
			}
		});
	}

	public int getLevel(){
		return comboBox.getSelectedIndex();
	}

	public void level() {
		//Đặt ô số ngẫu nhiên cho bằng 0
		int level = 2;
		switch (comboBox.getSelectedIndex()) {
		case 0:
			level = 2;
			break;
		case 1:
			level = 4;
			break;
		case 2:
			level = 8;
			break;

		default:
			break;
		}
		for (int l = 0; l < level; l++) {
			for (int k = 0; k < 9; k++) {
				int i = 1 + random.nextInt(8);
				matrix[k][i] = 0;
			}
			for (int k = 0; k < 9; k++) {
				int i = 1 + random.nextInt(8);
				matrix[i][k] = 0;
			}
		}

	}

	public void checkWin() {
		boolean win = true;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j].isEditable()) {
					String inputUser = board[i][j].getText();
					if (!inputUser.equals(String.valueOf(solvedMatrix[i][j]))) {
						win = false;
						numberCellIllegal++;
						board[i][j].setBackground(Color.red);
						board[i][j].setForeground(Color.yellow);
					} else {
						board[i][j].setBackground(Color.white);
						board[i][j].setForeground(Color.black);
					}
				}
			}
		}
		if (win == true) {
			JOptionPane.showMessageDialog(this, "Chúc mừng bạn đã giải thành công");
			lbMessage.setText("Winer !!!\n Tạo trò chơi mới");
		}else {
			lbMessage.setText(numberCellIllegal+" ô không hợp lệ");
		}
		numberCellIllegal=0;
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

	public void resetBoard() {
		matrix = new int[9][9];
		board[0][0].setText("");
		board[0][0].setBackground(Color.white);
		board[0][0].setEditable(true);
		board[0][0].setForeground(colorText);
		board[0][1].setText("");
		board[0][1].setBackground(Color.white);
		board[0][1].setEditable(true);
		board[0][1].setForeground(colorText);
		board[0][2].setText("");
		board[0][2].setBackground(Color.white);
		board[0][2].setEditable(true);
		board[0][2].setForeground(colorText);
		board[0][3].setText("");
		board[0][3].setBackground(Color.white);
		board[0][3].setEditable(true);
		board[0][3].setForeground(colorText);
		board[0][4].setText("");
		board[0][4].setBackground(Color.white);
		board[0][4].setEditable(true);
		board[0][4].setForeground(colorText);
		board[0][5].setText("");
		board[0][5].setBackground(Color.white);
		board[0][5].setEditable(true);
		board[0][5].setForeground(colorText);
		board[0][6].setText("");
		board[0][6].setBackground(Color.white);
		board[0][6].setEditable(true);
		board[0][6].setForeground(colorText);
		board[0][7].setText("");
		board[0][7].setBackground(Color.white);
		board[0][7].setEditable(true);
		board[0][7].setForeground(colorText);
		board[0][8].setText("");
		board[0][8].setBackground(Color.white);
		board[0][8].setEditable(true);
		board[0][8].setForeground(colorText);
		board[1][0].setText("");
		board[1][0].setBackground(Color.white);
		board[1][0].setEditable(true);
		board[1][0].setForeground(colorText);
		board[1][1].setText("");
		board[1][1].setBackground(Color.white);
		board[1][1].setEditable(true);
		board[1][1].setForeground(colorText);
		board[1][2].setText("");
		board[1][2].setBackground(Color.white);
		board[1][2].setEditable(true);
		board[1][2].setForeground(colorText);
		board[1][3].setText("");
		board[1][3].setBackground(Color.white);
		board[1][3].setEditable(true);
		board[1][3].setForeground(colorText);
		board[1][4].setText("");
		board[1][4].setBackground(Color.white);
		board[1][4].setEditable(true);
		board[1][4].setForeground(colorText);
		board[1][5].setText("");
		board[1][5].setBackground(Color.white);
		board[1][5].setEditable(true);
		board[1][5].setForeground(colorText);
		board[1][6].setText("");
		board[1][6].setBackground(Color.white);
		board[1][6].setEditable(true);
		board[1][6].setForeground(colorText);
		board[1][7].setText("");
		board[1][7].setBackground(Color.white);
		board[1][7].setEditable(true);
		board[1][7].setForeground(colorText);
		board[1][8].setText("");
		board[1][8].setBackground(Color.white);
		board[1][8].setEditable(true);
		board[1][8].setForeground(colorText);
		board[2][0].setText("");
		board[2][0].setBackground(Color.white);
		board[2][0].setEditable(true);
		board[2][0].setForeground(colorText);
		board[2][1].setText("");
		board[2][1].setBackground(Color.white);
		board[2][1].setEditable(true);
		board[2][1].setForeground(colorText);
		board[2][2].setText("");
		board[2][2].setBackground(Color.white);
		board[2][2].setEditable(true);
		board[2][2].setForeground(colorText);
		board[2][3].setText("");
		board[2][3].setBackground(Color.white);
		board[2][3].setEditable(true);
		board[2][3].setForeground(colorText);
		board[2][4].setText("");
		board[2][4].setBackground(Color.white);
		board[2][4].setEditable(true);
		board[2][4].setForeground(colorText);
		board[2][5].setText("");
		board[2][5].setBackground(Color.white);
		board[2][5].setEditable(true);
		board[2][5].setForeground(colorText);
		board[2][6].setText("");
		board[2][6].setBackground(Color.white);
		board[2][6].setEditable(true);
		board[2][6].setForeground(colorText);
		board[2][7].setText("");
		board[2][7].setBackground(Color.white);
		board[2][7].setEditable(true);
		board[2][7].setForeground(colorText);
		board[2][8].setText("");
		board[2][8].setBackground(Color.white);
		board[2][8].setEditable(true);
		board[2][8].setForeground(colorText);
		board[3][0].setText("");
		board[3][0].setBackground(Color.white);
		board[3][0].setEditable(true);
		board[3][0].setForeground(colorText);
		board[3][1].setText("");
		board[3][1].setBackground(Color.white);
		board[3][1].setEditable(true);
		board[3][1].setForeground(colorText);
		board[3][2].setText("");
		board[3][2].setBackground(Color.white);
		board[3][2].setEditable(true);
		board[3][2].setForeground(colorText);
		board[3][3].setText("");
		board[3][3].setBackground(Color.white);
		board[3][3].setEditable(true);
		board[3][3].setForeground(colorText);
		board[3][4].setText("");
		board[3][4].setBackground(Color.white);
		board[3][4].setEditable(true);
		board[3][4].setForeground(colorText);
		board[3][5].setText("");
		board[3][5].setBackground(Color.white);
		board[3][5].setEditable(true);
		board[3][5].setForeground(colorText);
		board[3][6].setText("");
		board[3][6].setBackground(Color.white);
		board[3][6].setEditable(true);
		board[3][6].setForeground(colorText);
		board[3][7].setText("");
		board[3][7].setBackground(Color.white);
		board[3][7].setEditable(true);
		board[3][7].setForeground(colorText);
		board[3][8].setText("");
		board[3][8].setBackground(Color.white);
		board[3][8].setEditable(true);
		board[3][8].setForeground(colorText);
		board[4][0].setText("");
		board[4][0].setBackground(Color.white);
		board[4][0].setEditable(true);
		board[4][0].setForeground(colorText);
		board[4][1].setText("");
		board[4][1].setBackground(Color.white);
		board[4][1].setEditable(true);
		board[4][1].setForeground(colorText);
		board[4][2].setText("");
		board[4][2].setBackground(Color.white);
		board[4][2].setEditable(true);
		board[4][2].setForeground(colorText);
		board[4][3].setText("");
		board[4][3].setBackground(Color.white);
		board[4][3].setEditable(true);
		board[4][3].setForeground(colorText);
		board[4][4].setText("");
		board[4][4].setBackground(Color.white);
		board[4][4].setEditable(true);
		board[4][4].setForeground(colorText);
		board[4][5].setText("");
		board[4][5].setBackground(Color.white);
		board[4][5].setEditable(true);
		board[4][5].setForeground(colorText);
		board[4][6].setText("");
		board[4][6].setBackground(Color.white);
		board[4][6].setEditable(true);
		board[4][6].setForeground(colorText);
		board[4][7].setText("");
		board[4][7].setBackground(Color.white);
		board[4][7].setEditable(true);
		board[4][7].setForeground(colorText);
		board[4][8].setText("");
		board[4][8].setBackground(Color.white);
		board[4][8].setEditable(true);
		board[4][8].setForeground(colorText);
		board[5][0].setText("");
		board[5][0].setBackground(Color.white);
		board[5][0].setEditable(true);
		board[5][0].setForeground(colorText);
		board[5][1].setText("");
		board[5][1].setBackground(Color.white);
		board[5][1].setEditable(true);
		board[5][1].setForeground(colorText);
		board[5][2].setText("");
		board[5][2].setBackground(Color.white);
		board[5][2].setEditable(true);
		board[5][2].setForeground(colorText);
		board[5][3].setText("");
		board[5][3].setBackground(Color.white);
		board[5][3].setEditable(true);
		board[5][3].setForeground(colorText);
		board[5][4].setText("");
		board[5][4].setBackground(Color.white);
		board[5][4].setEditable(true);
		board[5][4].setForeground(colorText);
		board[5][5].setText("");
		board[5][5].setBackground(Color.white);
		board[5][5].setEditable(true);
		board[5][5].setForeground(colorText);
		board[5][6].setText("");
		board[5][6].setBackground(Color.white);
		board[5][6].setEditable(true);
		board[5][6].setForeground(colorText);
		board[5][7].setText("");
		board[5][7].setBackground(Color.white);
		board[5][7].setEditable(true);
		board[5][7].setForeground(colorText);
		board[5][8].setText("");
		board[5][8].setBackground(Color.white);
		board[5][8].setEditable(true);
		board[5][8].setForeground(colorText);
		board[6][0].setText("");
		board[6][0].setBackground(Color.white);
		board[6][0].setEditable(true);
		board[6][0].setForeground(colorText);
		board[6][1].setText("");
		board[6][1].setBackground(Color.white);
		board[6][1].setEditable(true);
		board[6][1].setForeground(colorText);
		board[6][2].setText("");
		board[6][2].setBackground(Color.white);
		board[6][2].setEditable(true);
		board[6][2].setForeground(colorText);
		board[6][3].setText("");
		board[6][3].setBackground(Color.white);
		board[6][3].setEditable(true);
		board[6][3].setForeground(colorText);
		board[6][4].setText("");
		board[6][4].setBackground(Color.white);
		board[6][4].setEditable(true);
		board[6][4].setForeground(colorText);
		board[6][5].setText("");
		board[6][5].setBackground(Color.white);
		board[6][5].setEditable(true);
		board[6][5].setForeground(colorText);
		board[6][6].setText("");
		board[6][6].setBackground(Color.white);
		board[6][6].setEditable(true);
		board[6][6].setForeground(colorText);
		board[6][7].setText("");
		board[6][7].setBackground(Color.white);
		board[6][7].setEditable(true);
		board[6][7].setForeground(colorText);
		board[6][8].setText("");
		board[6][8].setBackground(Color.white);
		board[6][8].setEditable(true);
		board[6][8].setForeground(colorText);
		board[7][0].setText("");
		board[7][0].setBackground(Color.white);
		board[7][0].setEditable(true);
		board[7][0].setForeground(colorText);
		board[7][1].setText("");
		board[7][1].setBackground(Color.white);
		board[7][1].setEditable(true);
		board[7][1].setForeground(colorText);
		board[7][2].setText("");
		board[7][2].setBackground(Color.white);
		board[7][2].setEditable(true);
		board[7][2].setForeground(colorText);
		board[7][3].setText("");
		board[7][3].setBackground(Color.white);
		board[7][3].setEditable(true);
		board[7][3].setForeground(colorText);
		board[7][4].setText("");
		board[7][4].setBackground(Color.white);
		board[7][4].setEditable(true);
		board[7][4].setForeground(colorText);
		board[7][5].setText("");
		board[7][5].setBackground(Color.white);
		board[7][5].setEditable(true);
		board[7][5].setForeground(colorText);
		board[7][6].setText("");
		board[7][6].setBackground(Color.white);
		board[7][6].setEditable(true);
		board[7][6].setForeground(colorText);
		board[7][7].setText("");
		board[7][7].setBackground(Color.white);
		board[7][7].setEditable(true);
		board[7][7].setForeground(colorText);
		board[7][8].setText("");
		board[7][8].setBackground(Color.white);
		board[7][8].setEditable(true);
		board[7][8].setForeground(colorText);
		board[8][0].setText("");
		board[8][0].setBackground(Color.white);
		board[8][0].setEditable(true);
		board[8][0].setForeground(colorText);
		board[8][1].setText("");
		board[8][1].setBackground(Color.white);
		board[8][1].setEditable(true);
		board[8][1].setForeground(colorText);
		board[8][2].setText("");
		board[8][2].setBackground(Color.white);
		board[8][2].setEditable(true);
		board[8][2].setForeground(colorText);
		board[8][3].setText("");
		board[8][3].setBackground(Color.white);
		board[8][3].setEditable(true);
		board[8][3].setForeground(colorText);
		board[8][4].setText("");
		board[8][4].setBackground(Color.white);
		board[8][4].setEditable(true);
		board[8][4].setForeground(colorText);
		board[8][5].setText("");
		board[8][5].setBackground(Color.white);
		board[8][5].setEditable(true);
		board[8][5].setForeground(colorText);
		board[8][6].setText("");
		board[8][6].setBackground(Color.white);
		board[8][6].setEditable(true);
		board[8][6].setForeground(colorText);
		board[8][7].setText("");
		board[8][7].setBackground(Color.white);
		board[8][7].setEditable(true);
		board[8][7].setForeground(colorText);
		board[8][8].setText("");
		board[8][8].setBackground(Color.white);
		board[8][8].setEditable(true);
		board[8][8].setForeground(colorText);
	}


	public void handleExceptionInput() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				int i1 = i;
				int i2 = j;
				board[i][j].getDocument().addDocumentListener(new DocumentListener() {
					@Override
					public void removeUpdate(DocumentEvent e) {
						board[i1][i2].setBackground(Color.white);
						board[i1][i2].setForeground(Color.red);

					}

					@Override
					public void insertUpdate(DocumentEvent e) {
						board[i1][i2].setBackground(Color.white);
						board[i1][i2].setForeground(Color.red);

					}

					@Override
					public void changedUpdate(DocumentEvent e) {
						board[i1][i2].setBackground(Color.white);
						board[i1][i2].setForeground(Color.red);
					}
				});
			}
		}
	}

	public boolean isEmtry() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (!(matrix[i][j] == 0)) {
					return false;
				}

			}
		}
		return true;
	}

	public void showBoard() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (matrix[i][j] != 0) {
					board[i][j].setText(String.valueOf(matrix[i][j]));
					board[i][j].setEditable(false);
					board[i][j].setBackground(colorCell);
					board[i][j].setForeground(Color.black);
				}

			}
		}
	}

	public int[][] copyState(int[][] state) {
		int[][] result = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				result[i][j] = state[i][j];
			}
		}
		return result;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbNew) {
			resetBoard();
			controller.makeNewGame2(getLevel());
			matrix = copyState(model.getGraphSV().getMatrix());
			solvedMatrix = copyState(model.getSolved().getMatrix());
			level();
			showBoard();
			display2(matrix);
			if(model.isSuccess()) {
				lbMessage.setText("Tạo trò chơi thành công");
			}else {
				//lbMessage.setText("Tạo trò chơi thất bại");
				actionPerformed(e);
			}
			System.out.println("Xong rồi đây");
			graph = new Graph(matrix);
			graph.init();
			display2(matrix);
		}
		if (e.getSource() == jbSolved) {
			if (!isEmtry()) {
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						if (board[i][j].isEditable()) {
							board[i][j].setText(String.valueOf(solvedMatrix[i][j]));
							board[i][j].setBackground(colorSolved);
							board[i][j].setForeground(Color.red);
						}
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "Bạn phải tạo trò chơi mới");

			}
		}
		if (e.getSource() == jbCheck) {
			checkWin();
			handleExceptionInput();
			System.out.println("hello");
		}
	}
}
