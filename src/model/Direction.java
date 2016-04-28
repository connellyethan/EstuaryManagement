package model;

public enum Direction {
	NORTH, SOUTH, EAST, WEST,
	NORTHEAST, NORTHWEST, SOUTHEAST, SOUTHWEST;
	
	public static Direction getRandom(){
		return values()[(int) (Math.random() * values().length)];
	}

}
