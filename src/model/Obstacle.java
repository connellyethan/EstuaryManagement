package model;

import java.util.ArrayList;

import misc.RectangleBound;
import misc.Renderable;
import misc.Tickable;
import view.RenderInstructions;

public class Obstacle implements Renderable, Tickable{

	private ObsType type;
	private double velocity;
	private Direction direction;
	private Position position;
	private long timeCreated;
	private double renderWidth;
	private double renderHeight;
	
	private RectangleBound renderBounds;
	private RectangleBound hitBoxBounds;

	public Obstacle(ObsType type, Position pos, Direction dir) {
		this.type = type;
		velocity = .1;
		direction = dir;
		position = pos;
		renderWidth = 10;
		renderHeight = 10;
		timeCreated = System.nanoTime();
	}

	public ArrayList<RenderInstructions> getRenderInstuctions() {
		ArrayList<RenderInstructions> renderBatch = new ArrayList<RenderInstructions>();
		
		if (type == ObsType.INVASIVE_ANIMAL) {
			
			renderBatch.add(new RenderInstructions(position.getX(), position.getY(), "res/enemy1.png", renderWidth,
					renderHeight));
		}
		return renderBatch;
	}

	public void move() {
		if (direction == Direction.EAST) {
			position.addX(velocity);
		}
		else if (direction == Direction.WEST) {
			position.addX(-1 * velocity);
		}
		else if (direction == Direction.SOUTH) {
			position.addX(velocity);
		}
		if (direction == Direction.NORTH) {
			position.addX(-1 * velocity);
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

	@Override
	public void onTick() {
		// TODO Auto-generated method stub
		
	}

}
