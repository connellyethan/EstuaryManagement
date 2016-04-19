package screens;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import misc.Renderable;
import model.Position;
import model.Tool;
import model.ToolType;
import view.RenderInstructions;

public class ToolBox implements Renderable{
	
	private boolean toolInUse;
	private ToolType toolOut;
	private Position position;
	
	private double renderWidth;
	private double renderHeight;
	
	public ToolBox(Position position){
		toolInUse = false;
		toolOut  = null;
		this.position = position;
		
		renderHeight = 100 - position.getY();
		renderWidth = Math.max(25,100-(position.getX()*2));
	}
	
	 //x = 100 - x
	

	public Tool getTool(MouseEvent e){
		
		return null;
	}
	
	
	@Override
	public ArrayList<RenderInstructions> getRenderInstuctions() {
		ArrayList<RenderInstructions> renderBatch = new ArrayList<RenderInstructions>();
		
		RenderInstructions toolboxBar = new RenderInstructions(position.getX(), position.getY(), "res/toolbox.png", renderHeight,renderWidth);
		renderBatch.add(toolboxBar);
		
		return renderBatch;
	}
	
	

}
