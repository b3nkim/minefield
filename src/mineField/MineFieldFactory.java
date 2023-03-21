package mineField;

import javax.swing.JButton;

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
		if (type == "Move" && source instanceof JButton) {
			JButton button = (JButton) source;
			switch (button.getText()) {
				case "EAST":
					command = new MoveCommand(model, Heading.EAST);
					break;
				case "NORTH":
					command = new MoveCommand(model, Heading.NORTH);
					break;
				case "NORTHEAST":
					command = new MoveCommand(model, Heading.NORTHEAST);
					break;
				case "NORTHWEST":
					command = new MoveCommand(model, Heading.NORTHWEST);
					break;
				case "SOUTH":
					command = new MoveCommand(model, Heading.SOUTH);
					break;
				case "SOUTHEAST":
					command = new MoveCommand(model, Heading.SOUTHEAST);
					break;
				case "SOUTHWEST":
					command = new MoveCommand(model, Heading.SOUTHWEST);
					break;
				case "WEST":
					command = new MoveCommand(model, Heading.WEST);
					break;
				default:
					command = null;
			}
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
