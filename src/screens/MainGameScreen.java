package screens;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import main.ObsFun;
import misc.Preferences;
import misc.RectangleBound;
import model.Direction;
import model.ObsType;
import model.Obstacle;
import model.Position;
import model.Tool;
import view.RenderInstructions;

public class MainGameScreen extends Controller {

	private double timeLeft;
	private boolean mouseDown;
	private double health;

	private ToolBox toolbox;
	private Tool toolInUse;
	private ArrayList<Obstacle> obstaclesList;

	private long currentNs;
	private int secondsLeft;
	private int totalTime;
	private boolean gameOver;

	private final double NANOS_PER_SECOND = 1000000000.0;
	private final int NUM_SECONDS = 30;

	public final static double toolWidth = 10;
	public final static double toolHeight = 10;

	public MainGameScreen() {
		initialize();
	}

	@Override
	public void onTick(long deltaNs) {
		if (gameOver) {
			return;
		}

		// Takes care of time
		boolean onceCheck = false;
		currentNs += deltaNs;
		if (currentNs >= NANOS_PER_SECOND) {
			currentNs -= NANOS_PER_SECOND;
			secondsLeft--;
			totalTime++; //counts the total time for Obstacle addition
			onceCheck = true;
			if (secondsLeft <= 0) {
				gameOver = true;
			}
			System.out.println("Health is " + health);
			System.out.println("Time Left: " + secondsLeft);
		}
		
		//Adding Obstacles every n seconds
		if ((totalTime % 3 == 0 || obstaclesList.size() < 4) && onceCheck){
			
			for (int ic = 0; ic <3; ic++){
			obstaclesList.add(ObsFun.makeObs());
			}
			
			onceCheck = false;
		}

		// On tick and move
		for (int i = 0; i < obstaclesList.size(); i++) {
			Obstacle currentObstacle = obstaclesList.get(i);
			
			currentObstacle.onTick(deltaNs); // obstacles move
			currentObstacle.move();

			// Obstacles vanish if they're on screen for too long
			if (currentObstacle.lifetimeOver()) { 
				health += currentObstacle.getDeathValue();
				if (health <= 0){
					gameOver = true;
				}
				obstaclesList.remove(i);
				i--; // TODO check for errors in array shifting.
				continue;
			}
			
		}
		// Resolve collisions between obstacles
		for (int i = 0; i < obstaclesList.size(); i++) {
			Obstacle currentObstacle = obstaclesList.get(i);
		}

		// if tool over an enemy do stuff
		if (toolInUse != null) { // If tool in use
			for (int i = 0; i < obstaclesList.size(); i++) {
				double deltaScore = obstaclesList.get(i).calculateDeltaScore(toolInUse);
				if (deltaScore != 0) {
					health += deltaScore;
					obstaclesList.remove(i);
					i--; // TODO check for errors in array shifting.
				}
			}
		}
	}

	@Override
	public void initialize() {
		mouseDown = false;
		toolInUse = null;
		gameOver = false;
		
		obstaclesList = ObsFun.setupObs(10);
		
		health = 50;
		currentNs = 0;
		secondsLeft = NUM_SECONDS;
		timeLeft = NUM_SECONDS * NANOS_PER_SECOND;
		totalTime = 0;

		Position toolBoxPosition = new Position(10, 90);
		toolbox = new ToolBox();
	}

	@Override
	public ArrayList<RenderInstructions> getRenderInstuctions() {
		ArrayList<RenderInstructions> renderBatch = new ArrayList<RenderInstructions>();

		// Draw background
		RenderInstructions background;
		background = new RenderInstructions(0, 0, "res/background.png", 100, 100);
		renderBatch.add(background);

		// Draw enemies
		ArrayList<RenderInstructions> enemies = new ArrayList<RenderInstructions>();
		for (Obstacle obs : obstaclesList) {
			enemies.addAll(obs.getRenderInstuctions());
		}
		renderBatch.addAll(enemies);

		// Draw toolbox
		ArrayList<RenderInstructions> toolboxRender = toolbox.getRenderInstuctions();
		renderBatch.addAll(toolboxRender);

		// Draw tool in hand
		if (toolInUse != null) {
			renderBatch.addAll(toolInUse.getRenderInstuctions());
		}

		// Draw Timer
		// Draw Health

		return renderBatch;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (toolInUse == null) {
			return;
		}

		double x = e.getX();
		double y = e.getY();
		x = (x / Preferences.getWINDOW_WIDTH()) * 100.0;
		y = (y / Preferences.getWINDOW_HEIGHT()) * 100.0;
		toolInUse.setPosition(new Position(x, y));
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {

		mouseDown = true;

		double x = e.getX();
		double y = e.getY();
		x = (x / Preferences.getWINDOW_WIDTH()) * 100.0;
		y = (y / Preferences.getWINDOW_HEIGHT()) * 100.0;
		Position mouseClickPosition = new Position(x, y);

		toolInUse = toolbox.getTool(mouseClickPosition);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseDown = false;
		toolInUse = null;
		toolbox.returnTool();
	}

	public boolean isGameOver() {
		return gameOver;
	}

}
