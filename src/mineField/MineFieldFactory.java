package mineField;

import mvc.*;

public class MineFieldFactory implements AppFactory {
	
	public static Integer DIM = 20;

	@Override
	public Model makeModel() {
		return new MineField(DIM);
	}

	@Override
	public View makeView(Model model) {
		return new MineFieldView((MineField)model);
	}

	@Override
	public String[] getEditCommands() {
		// TODO add other commands
		return new String[]{"Move"};
	}

	@Override
	public Command makeEditCommand(Model model, String type, Object source) {
		Command command = null;
		if (type == "Move" && source instanceof Heading) {
			command = new MoveCommand(model, (Heading) source);
		}
		return command;
	}

	@Override
	public String getTitle() {
		return "Mine Field";
	}

	@Override
	public String[] getHelp() {
		return new String[] {
				"Move: 		Rock moves one cell in the given direction"
		};
	}

	@Override
	public String about() {
		return "Mine Field version 1.0. Copyright 2023 by Team 10";
	}

}
