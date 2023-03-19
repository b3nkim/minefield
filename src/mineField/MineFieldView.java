package mineField;

import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

// my MineField contains an n x n array of patches 
class Cell extends JLabel {
    Patch patch;
}

public class MineFieldView extends View {

    private Cell cells[][];
    public MineFieldView(MineField m) {
        super(m);
        int dim = m.getDim();
        cells = new Cell[dim][dim];
        setLayout(new GridLayout(dim, dim));
        for(int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
            
               // create and injitialize cells here, use
               cells[row][col].setBorder(BorderFactory.createLineBorder(Color.black));
               
            }
        }
    }


    public void propertyChange(PropertyChangeEvent evt) {
        // ???
    }


}