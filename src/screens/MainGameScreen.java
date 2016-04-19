package screens;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import misc.RectangleBound;
import model.Direction;
import model.ObsType;
import model.Obstacle;
import model.Position;
import view.RenderInstructions;

public class MainGameScreen extends Controller{

	private Obstacle obs;
	
	private ArrayList<Obstacle> obstaclesList;
	private ToolBox toolbox;
	
	
	public MainGameScreen() {
		obstaclesList = new ArrayList<Obstacle>();
		obs = new Obstacle(ObsType.INVASIVE_ANIMAL, new Position(50,50), Direction.WEST);
		
		Position toolBoxPosition = new Position(10,90);
		toolbox = new ToolBox(toolBoxPosition);
	}
	
	
	@Override
	public void onTick() {
		if(obs.getPosition().getX() > 100 - obs.getRenderWidth()){
			obs.setDirection(Direction.WEST);
		}
		else if(obs.getPosition().getX() < 0){
			obs.setDirection(Direction.EAST);
		}
		
		obs.move();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<RenderInstructions> getRenderInstuctions() {
		ArrayList<RenderInstructions> renderBatch = new ArrayList<RenderInstructions>();
		
		RenderInstructions background; 
		background = new RenderInstructions(0, 0, "res/background.png",100,100);
		renderBatch.add(background);
		
		ArrayList<RenderInstructions> enemy = obs.getRenderInstuctions();
		renderBatch.addAll(enemy);
		
		ArrayList<RenderInstructions> toolboxRender = toolbox.getRenderInstuctions();
		renderBatch.addAll(toolboxRender);
		
		
		return renderBatch;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
