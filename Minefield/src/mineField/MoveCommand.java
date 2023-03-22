package mineField;

import mvc.*;

public class MoveCommand extends Command {
	
	Heading heading;
	
	public MoveCommand(Model model, Heading heading) {
		super(model);
		this.heading = heading;
	}
	
	@Override
	public void execute() throws Exception {
		if (!(model instanceof MineField)) {
			throw new Exception("Model must instantiate MineField");
		}
		MineField minefield = (MineField)model;
		if (minefield.gameOver) {
			throw new Exception("You stepped on a mine :(");
		}
		minefield.updateLocation(heading);
	}

}
