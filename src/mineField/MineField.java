package mineField;

import java.io.Serializable;
import java.util.Random;

import mvc.*;

class Patch {
	boolean isMined;
}

public class MineField extends Model {

	public static int percentMined = 0;
	public Random rand;
	private int[] location;
	private int[][] field; //0 if not mine, 1 if is mine
	public MineField() {
		location = new int[] {0,0};
		field = new int[100][100];
		rand = new Random();
		randomizeMines();
	}
	public MineField(int size) {
		location = new int[] {0,0};
		field = new int[size][size];
		rand = new Random();
		randomizeMines();
	}
	public void randomizeMines() {
		int num;
		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j < field[i].length; j++) { 
				num = rand.nextInt(100);
				if(num <= 5) {
					field[i][j] = 1;
				}
				else {
					field[i][j] = 0;
				}
			}
		}
	}
	public int[] getLocation() {
		return location;
	}
	public int getX() {
		return field[0].length;
	}
	public int getY() {
		return field.length;
	}
	//movement commands, havent added checks for exceptions, you can do it later
	public void moveN() {
		setLocation(location[0], location[1]+1);
		//trigger update here
	}
	public void moveS() {
		setLocation(location[0], location[1]-1);
		//trigger update here
	}
	public void moveW() {
		setLocation(location[0]-1, location[1]);
		//trigger update here
	}
	public void moveE() {
		setLocation(location[0]+1, location[1]);
		//trigger update here
	}
	public void moveNE() {
		setLocation(location[0]+1, location[1]+1);
		//trigger update here
	}
	public void moveNW() {
		setLocation(location[0]-1, location[1]+1);
		//trigger update here
	}
	public void moveSE() {
		setLocation(location[0]+1, location[1]-1);
		//trigger update here
	}
	public void moveSW() {
		setLocation(location[0]-1, location[1]-1);
		//trigger update here
	}


	public void setLocation(int x, int y) {
		location = new int[] {x,y};
	}

}
