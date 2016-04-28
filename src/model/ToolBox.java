package model;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import misc.Renderable;
import screens.MainGameScreen;
import view.RenderInstructions;

public class ToolBox {

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


	public boolean isToolInUse() {
		return toolInUse;
	}


	public void setToolInUse(boolean toolInUse) {
		this.toolInUse = toolInUse;
	}


	public ToolType getToolOut() {
		return toolOut;
	}


	public void setToolOut(ToolType toolOut) {
		this.toolOut = toolOut;
	}


	public Position getToolboxPosition() {
		return toolboxPosition;
	}


	public void setToolboxPosition(Position toolboxPosition) {
		this.toolboxPosition = toolboxPosition;
	}


	public double getRenderWidth() {
		return renderWidth;
	}


	public void setRenderWidth(double renderWidth) {
		this.renderWidth = renderWidth;
	}


	public double getRenderHeight() {
		return renderHeight;
	}


	public void setRenderHeight(double renderHeight) {
		this.renderHeight = renderHeight;
	}
	
}
