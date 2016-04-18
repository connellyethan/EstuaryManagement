package model;

public class Obstacle {
	
	private ObsType type;
	private double velocity;
	private Direction direction;
	private Position position;
	private long timeCreated;

	public Obstacle(ObsType type, Position pos, Direction dir){
		this.type = type;
		velocity = 1;
		direction = dir;
		position = pos;
		timeCreated = System.nanoTime();
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

}
