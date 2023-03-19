package mineField;

import mvc.*;

import javax.swing.*;
import java.awt.*;

// my MineField contains an n x n array of patches 
class Cell extends JLabel {
	Patch patch;
}

class Patch {

}

public class MineFieldView extends View {

	private Cell cells[][];
	public MineFieldView(MineField m) {
		super(m);
		int dim = m.getDim();
		cells = new Cell[dim][dim];
		setLayout(new GridLayout(dim, dim));
		for(int row = 0; row < dim; row++) {
			for (int col = 0; col < dim; col++) {

				// create and injitialize cells here, use
				cells[row][col].setBorder(BorderFactory.createLineBorder(Color.black));

			}
		}
	}

	public void paintComponent(Graphics gc) {
		super.paintComponent(gc);
//		Color oldColor = gc.getColor();
//		Stoplight light = (Stoplight)model;
//		StoplightShape shape = new StoplightShape(light);
//		shape.draw((Graphics2D) gc);
//		gc.setColor(oldColor);
		MineField minefield = (MineField)model;
		MineFieldShape shape = new MineFieldShape(minefield);
		shape.draw((Graphics2D)gc);
	}

//	public void propertyChange(PropertyChangeEvent evt) {
//
//	}

}