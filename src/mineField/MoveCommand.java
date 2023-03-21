package mineField;

import mvc.*;

public class MoveCommand extends Command {
	
	Heading heading;
	
	public MoveCommand(Model model) {
		super(model);
		this.heading = null;
	}
	
	public void setHeading(Heading heading) {
		this.heading = heading;
	}

	@Override
	public void execute() throws Exception {
		if (!(model instanceof MineField)) {
			throw new Exception("Model must instantiate MineField");
		}
		MineField minefield = (MineField)model;
		minefield.updateLocation(heading);
	}

}
