package mvc;

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
		// TODO similar to turtle graphics
		return new JMenuBar();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO similar to turtle graphics
		try {

		} catch (Exception e) {
			handleException(e);
		}

	}

	protected void handleException(Exception e) {
		Utilities.error(e);
	}

}
