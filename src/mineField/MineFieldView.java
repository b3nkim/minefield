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
		int dim = m.getDim();
		Patch[][] patches = m.getPatches();
		cells = new Cell[dim][dim];
		setLayout(new GridLayout(dim, dim));
		for(int row = 0; row < dim; row++) {
			for (int col = 0; col < dim; col++) {
				Cell cell = new Cell();
				cell.patch = patches[row][col];
				cell.setBorder(BorderFactory.createLineBorder(Color.black));
				cell.setBackground(Color.GRAY);
				cell.setText("?");
				cell.setHorizontalAlignment(JLabel.CENTER);
			    cell.setVerticalAlignment(JLabel.CENTER);
			    cells[row][col] = cell;
				this.add(cells[row][col]);
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
	}

}