package mineField;

import java.io.Serializable;
import java.util.Random;

import mvc.*;

import java.util.Random;

class Patch {
	boolean isMined;
	boolean isTraveled;
	int neighbors;

	Patch() {
		isMined = false;
		isTraveled = false;
		neighbors = 0;
	}

	public boolean isMined() {
		return isMined;
	}
	public boolean isTraveled() {
		return isTraveled;
	}
	public int getNeighbors() {
		return neighbors;
	}
}

public class MineField extends Model {
	public static int percentMined = 5;
	private int dim;
	protected int rockY, rockX; // location of the Rock
	private Patch[][] patches;

	public MineField(int dim) {
		this.dim = dim;
		patches = new Patch[dim][dim];
		for (int row = 0; row < dim; row++) {
			for (int col = 0; col < dim; col++) {
				patches[row][col] = new Patch();
			}
		}
		
		rockX = 0;
		rockY = 0;
		patches[rockY][rockX].isTraveled = true;

		// generating the locations of the mines
		Random rand = new Random();
		double numMines = (percentMined * dim * dim) / 100.0;
		for (int i = 0; i < (int) numMines; i++) {
			int next1 = rand.nextInt(dim);
			int next2 = rand.nextInt(dim);
			System.out.printf("location of mine: %d, %d", next1, next2);
			patches[next1][next2].isMined = true;
		}

		// updating count for neighbors
		countNeighbors();

	}

	private void countNeighbors() {
		for (int row = 0; row < dim; row++) {
			for (int col = 0; col < dim; col++) {
				if (patches[row][col].isMined) {
					// checking borders
					if (row > 0) {
						if (col > 0) {
							patches[row - 1][col - 1].neighbors++;
						}
						patches[row - 1][col].neighbors++;
						if (col < dim - 1) {
							patches[row - 1][col + 1].neighbors++;	
						}
					}
					if (row < dim - 1) {
						if (col > 0) {
							patches[row + 1][col - 1].neighbors++;
						}
						patches[row + 1][col].neighbors++;
						if (col < dim - 1) {
							patches[row + 1][col + 1].neighbors++;
						}
					}
					if (col > 0) {
						patches[row][col - 1].neighbors++;
					}
					if (col < dim - 1) {
						patches[row][col + 1].neighbors++;
					}
				}
			}
		}
	}

	public void updateLocation(Heading heading) throws Exception {
		switch (heading) {
			case EAST:
				if (rockX == dim - 1) {
					throw new Exception("Cannot move off the grid");
				}
				rockX++;
				break;
			case NORTH:
				if (rockY == 0) {
					throw new Exception("Cannot move off the grid");
				}
				rockY--;
				break;
			case NORTHEAST:
				if (rockX == dim - 1 || rockY == 0) {
					throw new Exception("Cannot move off the grid");
				}
				rockX++;
				rockY--;
				break;
			case NORTHWEST:
				if (rockX == 0 || rockY == 0) {
					throw new Exception("Cannot move off the grid");
				}
				rockX--;
				rockY--;
				break;
			case SOUTH:
				if (rockY == dim - 1) {
					throw new Exception("Cannot move off the grid");
				}
				rockY++;
				break;
			case SOUTHEAST:
				if (rockX == dim - 1 || rockY == dim - 1) {
					throw new Exception("Cannot move off the grid");
				}
				rockX++;
				rockY++;
				break;
			case SOUTHWEST:
				if (rockX == 0 || rockY == dim - 1) {
					throw new Exception("Cannot move off the grid");
				}
				rockX--;
				rockY++;
				break;
			case WEST:
				if (rockX == 0) {
					throw new Exception("Cannot move off the grid");
				}
				rockX--;
				break;
			default:
				throw new Exception("Unrecognized heading");
			}
		patches[rockY][rockX].isTraveled = true;
		changed(); // from Model, sets changed flag and fires changed event
	}

	// getters and setters

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

	public Patch[][] getPatches() {
		return patches;
	}

}
