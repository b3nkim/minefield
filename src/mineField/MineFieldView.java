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
				cell.setOpaque(true);
				cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				cell.setBackground(Color.LIGHT_GRAY);
				cell.setText("" + cell.patch.neighbors);
				cell.setHorizontalAlignment(JLabel.CENTER);
			    cell.setVerticalAlignment(JLabel.CENTER);
			    cells[row][col] = cell;
				this.add(cells[row][col]);
			}
		}
		repaint();
	}

	public void paintComponent(Graphics gc) {
		super.paintComponent(gc);
		Color oldColor = gc.getColor();
		MineField minefield = (MineField) model;
		int dim = minefield.getDim();
		
		cells[dim - 1][dim - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		int rockY = minefield.getRockY();
		int rockX = minefield.getRockX();
		cells[rockY][rockX].patch.isTraveled = true;
		
		for(int row = 0; row < dim; row++) {
			for (int col = 0; col < dim; col++) {
				if (cells[row][col].patch.isTraveled) {
					cells[row][col].setBackground(Color.WHITE);
				}
				if (cells[row][col].patch.isMined) {
					cells[row][col].setBackground(Color.RED);
				}
			}
		}
			
		gc.setColor(oldColor);
	}

}