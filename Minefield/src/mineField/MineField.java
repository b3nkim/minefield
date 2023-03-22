package mineField;

import java.io.Serializable;

import mvc.*;

class Patch implements Serializable {
	boolean isMined;
	boolean isTraveled;
	boolean isEnd;
	int neighbors;

	Patch() {
		isMined = false;
		isTraveled = false;
		isEnd = false;
		neighbors = 0;
	}
}

public class MineField extends Model {
	public static int percentMined = 5;
	private int dim;
	protected int rockY, rockX; // location of the Rock
	private Patch[][] patches;
	boolean gameOver;

	public MineField(int dim) {
		this.dim = dim;
		patches = new Patch[dim][dim];
		for (int row = 0; row < dim; row++) {
			for (int col = 0; col < dim; col++) {
				patches[row][col] = new Patch();
				if(row == dim-1 && col == dim-1) {
					patches[row][col].isEnd = true;
				}
			}
		}
		
		rockX = 0;
		rockY = 0;
		patches[rockY][rockX].isTraveled = true;

		randomizeMines();
		countNeighbors();
		gameOver = false;
	}
	
	private void randomizeMines() {
		double numMines = (percentMined * dim * dim) / 100.0;
		for (int i = 0; i < (int) numMines; i++) {
			int next1 = Utilities.rng.nextInt(dim);
			int next2 = Utilities.rng.nextInt(dim);
			System.out.printf("location of mine: %d, %d\n", next1, next2);
			patches[next1][next2].isMined = true;
		}
		patches[0][0].isMined = false; // starting location
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
		if (patches[rockY][rockX].isMined) {
			gameOver = true;
			throw new Exception("You stepped on a mine :(");
		}
		if(patches[rockY][rockX].isEnd) {
			gameOver = true;
			throw new Exception("You made it to the end!!! GOOD JOB");
		}
	}
	
	// getters and setters
	public int getDim() {
		return dim;
	}

	public Patch[][] getPatches() {
		return patches;
	}

	public int getRockY() {
		return rockY;
	}

	public int getRockX() {
		return rockX;
	}

}
