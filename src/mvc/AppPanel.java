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
	public void actionPerformed(ActionEvent ae) {
		try {
			
		} catch (Exception e) {
			handleException(e);
		}
		
	}
	
	protected void handleException(Exception e) {
		Utilities.error(e);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}

}
