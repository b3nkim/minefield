package mineField;

import mvc.*;

class Patch {
	boolean isMined;
}

public class MineField extends Model {
	
	public static int percentMined = 5;
	private int dim;

	public int getDim() {
		return dim;
	}

}
