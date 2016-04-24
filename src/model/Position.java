package model;

public class Position {
	//Note: position refers to the pixel position of the upper-left hand corner of a given object
	private double x;
	private double y;
	
	public Position(double xPos, double yPos){
		this.x = xPos;
		this.y = yPos;
	}
	public static Position getRandom(int width, int height){
		return new Position((int) Math.random() * width, (int) Math.random() * height);
	}
	public double getX() {
		return x;
	}

	public void setX(double xPos) {
		this.x = xPos;
	}

	public double getY() {
		return y;
	}

	public void setY(double yPos) {
		this.y = yPos;
	}
	
	public void addX(double delta){
		this.x += delta;
	}
	public void addY(double delta){
		this.y += delta;
	}
	

}
