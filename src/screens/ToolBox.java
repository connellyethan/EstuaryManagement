package screens;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import misc.Renderable;
import model.Position;
import model.Tool;
import model.ToolType;
import view.RenderInstructions;

public class ToolBox implements Renderable {

	private boolean toolInUse;
	private ToolType toolOut;
	private Position toolboxPosition;

	private double renderWidth;
	private double renderHeight;

	public ToolBox() {
		toolInUse = false;
		toolOut = null;

		renderHeight = MainGameScreen.toolHeight;
		renderWidth = Math.min(100, 5 * MainGameScreen.toolWidth);
		
		this.toolboxPosition = new Position(((100 - renderWidth)/2.0), (100 - MainGameScreen.toolHeight));
	}


	public Tool getTool(Position pos) {
		double x = pos.getX();
		double y = pos.getY();

		if (x < toolboxPosition.getX() || x > toolboxPosition.getX() + renderWidth || y < toolboxPosition.getY()) {
			return null;
		}

		ToolType returnType = null;
		double xOffset = 0;
		if (x < (toolboxPosition.getX() + ((1 * renderWidth) / 5))) {
			System.out.println("TOOLBOX 1");
			xOffset = x - toolboxPosition.getX();
			returnType = ToolType.TRASHCAN;
		}
		else if (x < (toolboxPosition.getX() + ((2 * renderWidth) / 5))) {
			System.out.println("TOOLBOX 2");
			xOffset = x - toolboxPosition.getX() - ((1 * renderWidth) / 5);
			returnType = ToolType.HAND;
		}
		else if (x < (toolboxPosition.getX() + ((3 * renderWidth) / 5))) {
			System.out.println("TOOLBOX 3");
			xOffset = x - toolboxPosition.getX() - ((2 * renderWidth) / 5);
			returnType = ToolType.RESEARCHER;
		}
		else if (x < (toolboxPosition.getX() + ((4 * renderWidth) / 5))) {
			System.out.println("TOOLBOX 4");
			xOffset = x - toolboxPosition.getX() - ((3 * renderWidth) / 5);
			returnType = ToolType.CLIPBOARD;
		}
		else if (x < (toolboxPosition.getX() +  renderWidth)) {
			System.out.println("TOOLBOX 5");
			xOffset = x - toolboxPosition.getX() - ((4 * renderWidth) / 5);
			returnType = ToolType.VIAL;
		}

		toolInUse = true;
		toolOut = returnType;
		
		double yOffset = pos.getY() - toolboxPosition.getY();
		return new Tool(pos,returnType, xOffset, yOffset);
	}

	public void returnTool(){
		toolInUse = false;
		toolOut = null;
	}
	
	@Override
	public ArrayList<RenderInstructions> getRenderInstuctions() {
		ArrayList<RenderInstructions> renderBatch = new ArrayList<RenderInstructions>();

		double toolBoxX = toolboxPosition.getX();
		double toolBoxY = toolboxPosition.getY();
		RenderInstructions toolboxBar = new RenderInstructions(toolBoxX, toolBoxY, "res/toolbox.png",
				renderHeight, renderWidth);
		renderBatch.add(toolboxBar);
		
		RenderInstructions toolInstructions;
		if(toolOut != ToolType.TRASHCAN){
			toolInstructions = new RenderInstructions(toolBoxX,toolBoxY, "res/trashcan.png", renderHeight, renderWidth/5);
			renderBatch.add(toolInstructions);
		}
		if(toolOut != ToolType.HAND){
			toolInstructions = new RenderInstructions(toolBoxX + (renderWidth/5),toolBoxY, "res/hand.png", renderHeight, renderWidth/5);
			renderBatch.add(toolInstructions);
		}
		if(toolOut != ToolType.RESEARCHER){
			toolInstructions = new RenderInstructions(toolBoxX + ((2 * renderWidth)/5),toolBoxY, "res/researcher.png", renderHeight, renderWidth/5);
			renderBatch.add(toolInstructions);
		}
		if(toolOut != ToolType.CLIPBOARD){
			toolInstructions = new RenderInstructions(toolBoxX + ((3 * renderWidth)/5),toolBoxY, "res/clipboard.png", renderHeight, renderWidth/5);
			renderBatch.add(toolInstructions);
		}
		if(toolOut != ToolType.VIAL){
			toolInstructions = new RenderInstructions(toolBoxX + ((4 * renderWidth)/5),toolBoxY, "res/vial.png", renderHeight, renderWidth/5);
			renderBatch.add(toolInstructions);
		}
		
		return renderBatch;
	}
}
