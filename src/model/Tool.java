package model;

import java.io.Serializable;

public class Tool implements Serializable {
	
	private Position position;
	private ToolType type;
	
	public Tool(Position position, ToolType type) {
		this.position = position;
		this.type = type;
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
	
	public void setPosition(Position position) {
		this.position = position;
	}
	

}
