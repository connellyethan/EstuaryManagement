package model;

public class Obstacle {
	
	private ObsType type;
	private double velocity;
	private Direction direction;
	private Position position;
	private Time timeCreated;
	private State state;

	public Obstacle(Type type, Position pos, Direction dir){
		this.type = type;
		velocity = 1;
		direction = dir;
		position = pos;
		timeCreated = time.now();
		state = null;
		
	}
	
	public void onTick() {
		Move();
	}

	public void Move() {
		position.setX(position.getX() + velocity);
		position.setY(position.getY() + velocity);
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

	public Time getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Time timeCreated) {
		this.timeCreated = timeCreated;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
