package mvc;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AppPanel extends JPanel implements ActionListener, PropertyChangeListener {

	protected Model model;
	protected AppFactory factory;
	protected View view;
	protected JPanel controlPanel; // not a separate class!
	private SafeFrame frame;
	public static int FRAME_WIDTH = 500;
	public static int FRAME_HEIGHT = 300;

	public AppPanel(AppFactory factory) {
		super();
		// TODO Auto-generated constructor stub
		this.factory = factory;
		this.model = factory.makeModel();
		this.view = factory.makeView(model);
		this.controlPanel = new JPanel(); // TODO
		SafeFrame frame = new SafeFrame();
		Container cp = frame.getContentPane();
		cp.add(this);
		frame.setJMenuBar(this.createMenuBar());
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle(factory.getTitle());
		//		this.setLayout((new GridLayout(1, 2)));
		//		this.add(controls);
		//		this.add(canvas);

		display();
	}

	public void display() {
		frame.setVisible(true);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub

	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model.removePropertyChangeListener(this);
		this.model = model;
		this.model.initSupport(); // defined in Bean
		this.model.addPropertyChangeListener(this);
		view.setModel(this.model);
		model.changed();
	}


	protected JMenuBar createMenuBar() {
		JMenuBar result = new JMenuBar();

		JMenu fileMenu = Utilities.makeMenu("File", 
				new String[]{"New", "Save", "SaveAs", "Open", "Quit"}, this);
		result.add(fileMenu);

		String[] editCommands = factory.getEditCommands();
		JMenu editMenu = Utilities.makeMenu("Edit", editCommands, this);
		result.add(editMenu);

		JMenu helpMenu = Utilities.makeMenu("Help", 
				new String[]{"About", "Help"}, this);
		result.add(helpMenu);

		return result;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String actionCommand = ae.getActionCommand();
		try {
			switch (actionCommand) {
			
				case "About": {
					Utilities.inform(factory.about());
				}
				case "Help": {
					Utilities.inform(factory.getHelp());
					break;
				}
				default: {
					throw new Exception("Unrecognized command: " + actionCommand);
				}
			}

		} catch (Exception e) {
			handleException(e);
		}
	}

	protected void handleException(Exception e) {
		Utilities.error(e);
	}

}
