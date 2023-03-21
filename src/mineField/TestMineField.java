package mineField;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

public class TestMineField extends JComponent {
    private static MineField minefield = new MineField(20);
    private static MineFieldView view = new MineFieldView(minefield);
    
    public void paintComponent(Graphics gc) {
    	Graphics2D gc2d = (Graphics2D) gc;
        view.repaint();
    }
    
    public static void main(String[] args) {
    	JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setTitle("TestMineField");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(view);
        frame.setVisible(true);
    }
}
