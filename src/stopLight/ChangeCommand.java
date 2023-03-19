package stopLight;

import mvc.*;

public class ChangeCommand extends Command {

	public ChangeCommand(Model model) {
		super(model);
	}

	@Override
	public void execute() throws Exception {	
		if (!(model instanceof Stoplight)) {
			throw new Exception("Model must instantiate Stoplight");
		}
		Stoplight light = (Stoplight)model;
		light.change();
	}

//	@Override
//	public void undo() {
//		
//	}

}