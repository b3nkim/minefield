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
		return new String[]{};
	}

	@Override
	public Command makeEditCommand(Model model, String type, Object source) {
		Command command = null;
		if (type == "Move" && source instanceof JButton) {
			JButton button = (JButton) source;
			switch (button.getText()) {
				case "E":
					command = new MoveCommand(model, Heading.EAST);
					break;
				case "N":
					command = new MoveCommand(model, Heading.NORTH);
					break;
				case "NE":
					command = new MoveCommand(model, Heading.NORTHEAST);
					break;
				case "NW":
					command = new MoveCommand(model, Heading.NORTHWEST);
					break;
				case "S":
					command = new MoveCommand(model, Heading.SOUTH);
					break;
				case "SE":
					command = new MoveCommand(model, Heading.SOUTHEAST);
					break;
				case "SW":
					command = new MoveCommand(model, Heading.SOUTHWEST);
					break;
				case "W":
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
				"N:		move one space in the north direction",
				"S:		move one space in the south direction",
				"E:		move one space in the east direction",
				"W:		move one space in the west direction",
				"NE:		move one space in the northeast direction",
				"NW:		move one space in the northwest direction",
				"SE:		move one space in the southeast direction",
				"SW:		move one space in the southwest direction"
		};
	}

	@Override
	public String about() {
		return "Mine Field version 1.0. Copyright 2023 by Team 10";
	}

}
