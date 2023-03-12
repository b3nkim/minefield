package mvc;

abstract public class Command {
	
	protected Model model;
	
	public Command(Model model) {
		// TODO Auto-generated constructor stub
	}

	abstract public void execute() throws Exception;
}
