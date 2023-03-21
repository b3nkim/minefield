package mineField;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import mvc.*;

public class MineFieldPanel extends AppPanel implements ActionListener{

	public MineField mainMine;
	public ControlPanel controls;
	public MineFieldView view;

	public JButton NW = new JButton("NW");
	public JButton N = new JButton("N");
	public JButton NE = new JButton("NE");
	public JButton W = new JButton("W");
	public JButton E = new JButton("E");
	public JButton S = new JButton("S");
	public JButton SE = new JButton("SE");
	public JButton SW = new JButton("SW");	

	public MineFieldPanel(AppFactory factory) {
		super(factory);

		mainMine = new MineField();
		view = new MineFieldView(mainMine);
		view.setSize(500,500);

		controls = new ControlPanel();
		controls.setSize(500,500);

		this.setLayout(new GridLayout(1,2));
		this.add(controls);
		this.add(view);
		this.setSize(1000,500);

	}

	@Override 
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == NW) {
			mainMine.moveNW();
		}
		else if(e.getSource() == N) {
			mainMine.moveN();
		}
		else if(e.getSource() == NE) {
			mainMine.moveNE();
		}
		else if(e.getSource() == W) {
			mainMine.moveW();
		}
		else if(e.getSource() == E) {
			mainMine.moveE();
		}
		else if(e.getSource() == S) {
			mainMine.moveS();
		}
		else if(e.getSource() == SE) {
			mainMine.moveSE();
		}
		else if(e.getSource() == SW) {
			mainMine.moveSW();
		}
	}


	public static void main(String[] args) {
		AppFactory factory = new MineFieldFactory();
		MineFieldPanel panel = new MineFieldPanel(factory);
		panel.display();
	}


	class ControlPanel extends JPanel {

		public JButton NW = new JButton("NW");
		public JButton N = new JButton("N");
		public JButton NE = new JButton("NE");
		public JButton W = new JButton("W");
		public JButton E = new JButton("E");
		public JButton S = new JButton("S");
		public JButton SE = new JButton("SE");
		public JButton SW = new JButton("SW");	

		JPanel outPanel;

		public ControlPanel() {
			setBackground(Color.pink);

			NW.addActionListener(MineFieldPanel.this);		
			N.addActionListener(MineFieldPanel.this);		
			NE.addActionListener(MineFieldPanel.this);		
			W.addActionListener(MineFieldPanel.this);		
			E.addActionListener(MineFieldPanel.this);		
			S.addActionListener(MineFieldPanel.this);
			SE.addActionListener(MineFieldPanel.this);
			SW.addActionListener(MineFieldPanel.this);

			GridLayout layout = new GridLayout(3,3);
			layout.setHgap(30);
			layout.setVgap(30);
			this.setLayout(layout);
			this.add(N);
			this.add(NW);
			this.add(NE);
			this.add(W);
			this.add(E);
			this.add(S);
			this.add(SE);
			this.add(SW);

		}
	}
}
