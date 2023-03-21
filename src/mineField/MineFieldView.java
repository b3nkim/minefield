package mineField;

import mvc.*;

import javax.swing.*;
import java.awt.*;

// my MineField contains an n x n array of patches 
class Cell extends JLabel {
	Patch patch;
}

public class MineFieldView extends View {

	private Cell cells[][];
	public MineFieldView(MineField m) {
		super(m);
		cells = new Cell[m.getX()][m.getY()];
		setLayout(new GridLayout(m.getX(), m.getY()));
		for(int row = 0; row < m.getX(); row++) {
			for (int col = 0; col < m.getY(); col++) {
				cells[row][col] = new Cell();
				cells[row][col].setBorder(BorderFactory.createLineBorder(Color.black));

			}
		}
	}

	public void update() {
		repaint();
	}

	public void ChangeCell() {
		//change cell from a blank one to one that has been traversed over, decide which number to put in as well
	}
	public void paintComponent(Graphics gc) {
		super.paintComponent(gc);
		MineField minefield = (MineField)model;
		MineFieldShape shape = new MineFieldShape(minefield);
		shape.draw((Graphics2D)gc);
	}
}