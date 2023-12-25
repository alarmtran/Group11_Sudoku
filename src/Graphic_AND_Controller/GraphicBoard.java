package Graphic_AND_Controller;

import javax.swing.*;
import java.awt.*;

public class GraphicBoard extends JLayeredPane {
	GridLayout grid;
	
	public GraphicBoard(GridLayout grid) {
		this.grid=grid;
		this.setLayout(grid);

	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
		Stroke stroke1 = new BasicStroke(5f);
		g2d.setStroke(stroke1);
		
        int x = 10;
        int widthCell = (int)((this.getWidth()-20)/3);
        int heightCell =(int)((this.getHeight()-20)/3);
        for (int i = x+widthCell; i <= this.getWidth()-20; i += widthCell) {
            g2d.drawLine(i, x, i, this.getHeight()-20+x);
        }

        for (int i = x+heightCell; i <= this.getHeight()-20; i += heightCell) {
            g2d.drawLine(x, i, this.getWidth()-20+x, i);
        }
    }
	
public static void main(String[] args) {

}

}
