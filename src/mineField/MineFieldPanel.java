package mineField;

import java.beans.PropertyChangeEvent;

import javax.swing.JButton;

import mvc.*;

public class MineFieldPanel extends AppPanel {

	JButton NW = new JButton("NW");
	JButton N = new JButton("N");
	JButton NE = new JButton("NE");
	JButton W = new JButton("W");
	JButton E = new JButton("SW");
	JButton S = new JButton("SE");
	
	public MineFieldPanel(AppFactory factory) {
		super(factory);
		// TODO Auto-generated constructor stub
		
		MineField minefield = (MineField) model;
		minefield.addPropertyChangeListener(this);
//		controlPanel.setLayout();
	}
	
	@Override
    public void propertyChange(PropertyChangeEvent evt) {
        super.propertyChange(evt);
        MineField minefield = (MineField) model;
        // TODO
    }

	public static void main(String[] args) {
        AppFactory factory = new MineFieldFactory();
        AppPanel panel = new MineFieldPanel(factory);
        panel.display();
    }
}
