package mineField;

import java.awt.Graphics2D;

public class MineFieldShape {
	
	private MineField minefield;
	private int height, width, xc, yc;
	
	public MineFieldShape(MineField minefield, int xc, int yc) {
		this.minefield = minefield;
		this.xc = xc;
		this.yc = yc;
	}
	
	public MineFieldShape(MineField minefield) {
		this(minefield, 50, 50);
	}
	
	public void draw(Graphics2D gc) {
		
	}

}
