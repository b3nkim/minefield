package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AppPanel extends JPanel implements ActionListener, PropertyChangeListener {
	
	public class ControlPanel extends JPanel {
        public ControlPanel() {
//            setBackground(Color.PINK);
//            JPanel p = new JPanel();
//            JButton change = new JButton("Change");
//            change.addActionListener(AppPanel.this);
//            p.add(change);
//            add(p);
        }
    }
	
	View view;
	protected ControlPanel controls;
	Model model;
	AppFactory factory;

	public AppPanel(AppFactory factory) {
		// TODO Auto-generated constructor stub
	}

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

	public void display() {
		// TODO Auto-generated method stub
		
	}

}
