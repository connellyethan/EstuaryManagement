package model;

import view.RenderInstructions;

public class Obstacle {
	
	private ObsType type;
	private double velocity;
	private Direction direction;
	private Position position;
	private long timeCreated;
	private double renderWidth;
	private double renderHeight;
	
	public Obstacle(ObsType type, Position pos, Direction dir){
		this.type = type;
		velocity = 1;
		direction = dir;
		position = pos;
		renderWidth = 10;
		renderHeight = 10;
		timeCreated = System.nanoTime();
	}
	
	public RenderInstructions getRenderInstuctions(){
		if(type == ObsType.INVASIVE_ANIMAL){
			return new RenderInstructions(position.getX(), position.getY(), "res/enemy1.png", renderWidth, renderHeight);
		}
		return null;
	}
	
	public void move(){
		if(direction == Direction.EAST){
			position.addX((int)velocity);
		}
		else if(direction == Direction.WEST){
			position.addX((int) (-1 * velocity));
		}
	}
	
	
	
	
	public void onDestory() {

	}

	public ObsType getType() {
		return type;
	}

	public void setType(ObsType type) {
		this.type = type;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public long getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(long timeCreated) {
		this.timeCreated = timeCreated;
	}
	public double getRenderWidth() {
		return renderWidth;
	}

	public double getRenderHeight() {
		return renderHeight;
	}

}
