package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JPanel;

public class AppPanel extends JPanel implements ActionListener, PropertyChangeListener {
	
	View view;
	ControlPanel controlPanel;
	Model model;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}

}
