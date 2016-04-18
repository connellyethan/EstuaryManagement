package model;

public enum ToolType {
	TRASHCAN(0), HAND(1), RESEARCHER(2),
	CLIPBOARD(3), VIAL(4);
private int value;
	private ToolType(int value){
		this.value = value;
	}
}

