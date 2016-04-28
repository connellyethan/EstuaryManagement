package model;

import java.io.Serializable;
import java.util.ArrayList;

import misc.RectangleBound;
import misc.Renderable;
import screens.MainGameScreen;
import view.RenderInstructions;

public class Tool implements Renderable {
	
	private Position position;
	private ToolType type;
	private double xOffset;
	private double yOffset;
	private double toolheight = MainGameScreen.toolHeight;
	private double toolwidth = MainGameScreen.toolWidth;
	
	public double getToolHeight() {
		return toolheight;
	}


	public double getToolWidth() {
		return toolwidth;
	}


	public Tool(Position position, ToolType type) {
		this(position, type, 0,0);
	}
	
	
	public Tool(Position position, ToolType type, double xOffset, double yOffset) {
		this.type = type;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		setPosition(position);
		toolheight = MainGameScreen.toolHeight;
		toolwidth = MainGameScreen.toolWidth;
	}

	public RectangleBound getHitbox(){
		return new RectangleBound(
				getPosition().getX(), 
				getPosition().getY(), 
				getPosition().getX() + getToolWidth(), 
				getPosition().getY() + getToolHeight());
	}

	public void onDestroy(){
	}

	
	public void setType(ToolType type){
		this.type = type;
	}
	
	public ToolType getType(){
		return type;
	}
	
	public Position getPosition(){
		return position;
	}
	
	public void setPosition(Position pos) {
		this.position = new Position(pos.getX() - xOffset, pos.getY() - yOffset);
	}

	@Override
	public ArrayList<RenderInstructions> getRenderInstuctions() {
		ArrayList<RenderInstructions> renderBatch = new ArrayList<RenderInstructions>();
		String toolImagePath = "";
		
		
		if(type == ToolType.TRASHCAN){
			toolImagePath = "res/trashcan.png";
		}
		else if(type == ToolType.HAND){
			toolImagePath = "res/hand.png";
		}
		else if(type == ToolType.RESEARCHER){
			toolImagePath = "res/researcher.png";
		}
		else if(type == ToolType.CLIPBOARD){
			toolImagePath = "res/clipboard.png";
		}
		else if(type == ToolType.VIAL){
			toolImagePath = "res/vial.png";
		}
		
		
		RenderInstructions toolRender = new RenderInstructions(position.getX(), position.getY(), toolImagePath, toolheight, toolwidth);
		renderBatch.add(toolRender);
		
		return renderBatch;
	}
	

}
