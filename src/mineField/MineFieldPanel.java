package mineField;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import mvc.*;

public class MineFieldPanel extends AppPanel {

	private JButton NW, N, NE, W, E, S, SE, SW;

	public MineFieldPanel(AppFactory factory) {
		super(factory);
		controlPanel.setLayout(new BorderLayout());
		initButtons();
	}

	private void initButtons() {
		JPanel headings = new JPanel();
		headings.setLayout(new GridLayout(3, 3));

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
		
		JPanel p = new JPanel();
		p.add(NW);
		headings.add(p);
		
		p = new JPanel();
		p.add(N);
		headings.add(p);
		
		p = new JPanel();
		p.add(NE);
		headings.add(p);
		
		p = new JPanel();
		p.add(W);
		headings.add(p);
		
		p = new JPanel();
		headings.add(p);
		
		p = new JPanel();
		p.add(E);
		headings.add(p);
		
		p = new JPanel();
		p.add(SW);
		headings.add(p);
		
		p = new JPanel();
		p.add(S);
		headings.add(p);
		
		p = new JPanel();
		p.add(SE);
		headings.add(p);

		controlPanel.add(headings, "Center");
	}

	public static void main(String[] args) {
		AppFactory factory = new MineFieldFactory();
		MineFieldPanel panel = new MineFieldPanel(factory);
		panel.display();
	}
}
