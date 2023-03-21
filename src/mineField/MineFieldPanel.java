package mineField;

import java.awt.GridLayout;

import javax.swing.JButton;

import mvc.*;

public class MineFieldPanel extends AppPanel {

	private JButton NW, N, NE, W, E, S, SE, SW;

	public MineFieldPanel(AppFactory factory) {
		super(factory);
		
//		MineField minefield = (MineField) model;
//		minefield.addPropertyChangeListener(this);
		controlPanel.setLayout(new GridLayout(4,2));
		initButtons();

	}
	
	private void initButtons() {		
		NW = new JButton("NW");
		N = new JButton("N");
		NE = new JButton("NE");
		W = new JButton("W");
		E = new JButton("E");
		S = new JButton("S");
		SE = new JButton("SE");
		SW = new JButton("SW");	
		
		NW.setActionCommand("Move");
		N.setActionCommand("Move");
		NE.setActionCommand("Move");
		W.setActionCommand("Move");
		E.setActionCommand("Move");
		S.setActionCommand("Move");
		SE.setActionCommand("Move");
		SW.setActionCommand("Move");
		
		NW.addActionListener(this);
		N.addActionListener(this);
		NE.addActionListener(this);
		W.addActionListener(this);
		E.addActionListener(this);
		S.addActionListener(this);
		SE.addActionListener(this);
		SW.addActionListener(this);
		
		controlPanel.add(NW);
		controlPanel.add(N);
		controlPanel.add(NE);
		controlPanel.add(W);
		controlPanel.add(E);
		controlPanel.add(S);
		controlPanel.add(SE);
		controlPanel.add(SW);
	}

	public static void main(String[] args) {
		AppFactory factory = new MineFieldFactory();
		MineFieldPanel panel = new MineFieldPanel(factory);
		panel.display();
	}
}
