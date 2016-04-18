package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ModelTests {

	@Test
	public void trashcanTest(){
		Tool trashcan = new Tool((new Position(0, 0)), ToolType.TRASHCAN);
	}
	
	@Test
	public void clipboardTest(){
		Tool clipboard = new Tool((new Position(0, 0)), ToolType.CLIPBOARD);
	}
	
	@Test
	public void handTest(){
		Tool hand = new Tool((new Position(0, 0)), ToolType.HAND);
	}
	
	@Test
	public void vialTest(){
		Tool vial = new Tool((new Position(0, 0)), ToolType.VIAL);
	}
	
	@Test
	public void researcherTest(){
		Tool researcher = new Tool((new Position(0, 0)), ToolType.RESEARCHER);
	}
	
	

}
