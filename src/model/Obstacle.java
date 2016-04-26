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
	private double theta;
	private Position position;
	private final double NORTH = 270.0;
	private final double SOUTH = 90.0;
	private final double EAST = 0.0;
	private final double WEST = 180.0;
	
	private long lifeSpan;
	private long timeElapsed;
	
	private double renderWidth;
	private double renderHeight;
	
	private double deathValue;
	private double onToolMatch;
	private double onToolMisMatch;

	private RectangleBound renderBounds;
	private RectangleBound hitBoxBounds;

	public Obstacle(ObsType type, Position pos) {
		this(type,pos, 0);
	}
	public Obstacle(ObsType type, Position pos, double theta){
		this.type = type;
		velocity = .4;
		position = pos;
		renderWidth = 10;
		renderHeight = 10;
		deathValue = -8.0;
		onToolMatch = 5;
		onToolMisMatch = -5;
		timeElapsed = 0;
		this.theta = theta;
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
		position.addX(velocity * Math.cos(Math.toRadians(theta)));
		position.addY(velocity * Math.sin(Math.toRadians(theta)));
		
		if(getPosition().getX() > 100 - getRenderWidth()){
			setTheta(WEST);
		}
		else if(getPosition().getX() < 0){
			setTheta(EAST);
		}
		else if(getPosition().getY() < 0){
			setTheta(SOUTH);
		}
		else if(getPosition().getY() > 100 - getRenderHeight()){
			setTheta(NORTH);
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

	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}

}
