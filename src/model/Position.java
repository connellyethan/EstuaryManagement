package model;

public class Position {
	//Note: position refers to the pixel position of the upper-left hand corner of a given object
	private int x;
	private int y;
	
	public Position(int xPos, int yPos){
		this.x = xPos;
		this.y = yPos;
	}

	public int getX() {
		return x;
	}

	public void setX(int xPos) {
		this.x = xPos;
	}

	public int getY() {
		return y;
	}

	public void setY(int yPos) {
		this.y = yPos;
	}
	
	

}
