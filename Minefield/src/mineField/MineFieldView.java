package mineField;

import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

// my MineField contains an n x n array of patches 
class Cell extends JLabel {
	Patch patch;
}

public class MineFieldView extends View {

	private Cell cells[][];
	public MineFieldView(MineField m) {
		super(m);
		this.addPropertyChangeListener(this);
		int dim = m.getDim();
		setLayout(new GridLayout(dim, dim));
		initCells();
		repaint();
	}
	
	private void initCells() {		
		MineField minefield = (MineField) model;
		int dim = minefield.getDim();
		Patch[][] patches = minefield.getPatches();
		cells = new Cell[dim][dim];
		for(int row = 0; row < dim; row++) {
			for (int col = 0; col < dim; col++) {
				Cell cell = new Cell();
				cell.patch = patches[row][col];
				cell.setOpaque(true);
				cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				cell.setBackground(Color.LIGHT_GRAY);
				cell.setText("?");
				cell.setHorizontalAlignment(JLabel.CENTER);
			    cell.setVerticalAlignment(JLabel.CENTER);
			    cells[row][col] = cell;
				this.add(cells[row][col]);
			}
		}
		cells[dim - 1][dim - 1].setBorder(BorderFactory.createLineBorder(Color.GREEN));
	}

	// TODO: override setModel?
	public void paintComponent(Graphics gc) {
		super.paintComponent(gc);
		Color oldColor = gc.getColor();
		MineField minefield = (MineField) model;
		int dim = minefield.getDim();
		int rockY = minefield.getRockY();
		int rockX = minefield.getRockX();
		cells[rockY][rockX].patch.isTraveled = true;

		for(int row = 0; row < dim; row++) {
			for (int col = 0; col < dim; col++) {
				if (cells[row][col].patch.isTraveled) {
					if (cells[row][col].patch.isMined) {
						cells[row][col].setBackground(Color.RED);
						cells[row][col].setText("X");
					} else {
						cells[row][col].setBackground(Color.WHITE);
						cells[row][col].setText("" + cells[row][col].patch.neighbors);
					}
				}
			}
		}

		gc.setColor(oldColor);
	}
}