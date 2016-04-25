package model;

import java.awt.Rectangle;
import java.util.ArrayList;

import misc.RectangleBound;
import misc.Renderable;
import misc.Tickable;
import misc.Utilities;
import view.RenderInstructions;

public class Obstacle implements Renderable, Tickable {

	private ObsType type;
	
	private double velocity;
	private Direction direction;
	private Position position;
	
	private long lifeSpan;
	private long timeElapsed;
	
	private double renderWidth;
	private double renderHeight;
	
	private double deathValue;
	private double onToolMatch;
	private double onToolMisMatch;

	private RectangleBound renderBounds;
	private RectangleBound hitBoxBounds;

	public Obstacle(ObsType type, Position pos, Direction dir) {
		this.type = type;
		velocity = .3;
		direction = dir;
		position = pos;
		renderWidth = 10;
		renderHeight = 10;
		deathValue = -8.0;
		onToolMatch = 5;
		onToolMisMatch = -5;
		timeElapsed = 0;
		lifeSpan = Utilities.NANOS_PER_SECOND * 6;
	}

	public ArrayList<RenderInstructions> getRenderInstuctions() {
		ArrayList<RenderInstructions> renderBatch = new ArrayList<RenderInstructions>();

		if (type == ObsType.TRASH) {
			renderBatch.add(new RenderInstructions(position.getX(), position.getY(), "res/trash.png", renderWidth,
					renderHeight));
		}
		if (type == ObsType.INVASIVE_PLANT) {
			renderBatch.add(new RenderInstructions(position.getX(), position.getY(), "res/invasivePlant.png", renderWidth,
					renderHeight));
		}
		if (type == ObsType.NON_INVASIVE_PLANT) {
			renderBatch.add(new RenderInstructions(position.getX(), position.getY(), "res/nonInvasivePlant.png", renderWidth,
					renderHeight));
		}
		if (type == ObsType.INVASIVE_ANIMAL) {
			renderBatch.add(new RenderInstructions(position.getX(), position.getY(), "res/invasiveAnimal.png", renderWidth,
					renderHeight));
		}
		if (type == ObsType.NON_INVASIVE_ANIMAL) {
			renderBatch.add(new RenderInstructions(position.getX(), position.getY(), "res/nonInvasiveAnimal.png", renderWidth,
					renderHeight));
		}
		if (type == ObsType.POLLUTION) {
			renderBatch.add(new RenderInstructions(position.getX(), position.getY(), "res/pollution.png", renderWidth,
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
			position.addY(velocity);
		}
		if (direction == Direction.NORTH) {
			position.addY(-1 * velocity);
		}
		
		if(getPosition().getX() > 100 - getRenderWidth()){
			setDirection(Direction.WEST);
		}
		else if(getPosition().getX() < 0){
			setDirection(Direction.EAST);
		}
		else if(getPosition().getY() < 0){
			setDirection(Direction.SOUTH);
		}
		else if(getPosition().getY() > 100 - getRenderHeight()){
			setDirection(Direction.NORTH);
		}
	}

	@Override
	public void onTick(long deltaNs) {
		timeElapsed += deltaNs;
	}


	public double calculateDeltaScore(Tool tool) {
		
		if (!Utilities.hasCollided(tool.getHitbox(), this.getHitbox())){
			return 0.0;
		}

		if (Utilities.typesAreCompatable(this.getType(), tool.getType())) {
			return onToolMatch;
		}
		else {
			return onToolMisMatch;
		}
	}

	public RectangleBound getHitbox(){
		return new RectangleBound(
				getPosition().getX(), 
				getPosition().getY(), 
				getPosition().getX() + getRenderWidth(), 
				getPosition().getY() + getRenderHeight());
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

	public double getRenderWidth() {
		return renderWidth;
	}

	public double getRenderHeight() {
		return renderHeight;
	}

	public boolean lifetimeOver() {
		return timeElapsed > lifeSpan;
	}

	public double getDeathValue() {
		return deathValue;
		// TODO Auto-generated method stub
	}

}
