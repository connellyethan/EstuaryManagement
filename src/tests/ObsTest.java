package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Direction;
import model.ObsType;
import model.Obstacle;
import model.Position;

public class ObsTest {

	@Test
	public void test0() {
		Position pos = new Position(5, 5);
		Direction dir = Direction.NORTH;
		Obstacle obs = new Obstacle(ObsType.TRASH, pos, dir);
		assertEquals(obs.getType(), ObsType.TRASH);

	}
	@Test
	public void test1() {
		Position pos = new Position(5, 5);
		Direction dir = Direction.NORTH;
		Obstacle obs = new Obstacle(ObsType.INVASIVE_PLANT, pos, dir);
		assertEquals(obs.getType(), ObsType.INVASIVE_PLANT);

	}
	@Test
	public void test2() {
		Position pos = new Position(5, 5);
		Direction dir = Direction.NORTH;
		Obstacle obs = new Obstacle(ObsType.NON_INVASIVE_PLANT, pos, dir);
		assertEquals(obs.getType(), ObsType.NON_INVASIVE_PLANT);

	}
	@Test
	public void test3() {
		Position pos = new Position(5, 5);
		Direction dir = Direction.NORTH;
		Obstacle obs = new Obstacle(ObsType.INVASIVE_ANIMAL, pos, dir);
		assertEquals(obs.getType(), ObsType.INVASIVE_ANIMAL);

	}
	@Test
	public void test4() {
		Position pos = new Position(5, 5);
		Direction dir = Direction.NORTH;
		Obstacle obs = new Obstacle(ObsType.NON_INVASIVE_PLANT, pos, dir);
		assertEquals(obs.getType(), ObsType.NON_INVASIVE_PLANT);

	}
	@Test
	public void test5() {
		Position pos = new Position(5, 5);
		Direction dir = Direction.NORTH;
		Obstacle obs = new Obstacle(ObsType.POLLUTION, pos, dir);
		assertEquals(obs.getType(), ObsType.POLLUTION);

	}
	@Test
	public void test6() {
		Position pos = new Position(5, 5);
		Direction dir = Direction.NORTH;
		Obstacle obs = new Obstacle(ObsType.HORSESHOE_CRAB, pos, dir);
		assertEquals(obs.getType(), ObsType.HORSESHOE_CRAB);

	}
	
	@Test
	public void test7() {
		Position pos = new Position(5, 5);
		Direction dir = Direction.NORTH;
		Obstacle obs = new Obstacle(ObsType.TRASH, pos, dir);
		assertEquals(obs.getDirection(), Direction.NORTH);

	}
	@Test
	public void test8() {
		Position pos = new Position(5, 5);
		Direction dir = Direction.SOUTH;
		Obstacle obs = new Obstacle(ObsType.TRASH, pos, dir);
		assertEquals(obs.getDirection(), Direction.SOUTH);

	}
	@Test
	public void test9() {
		Position pos = new Position(5, 5);
		Direction dir = Direction.EAST;
		Obstacle obs = new Obstacle(ObsType.TRASH, pos, dir);
		assertEquals(obs.getDirection(), Direction.EAST);
	}
	
	@Test
	public void test10() {
		Position pos = new Position(5, 5);
		Direction dir = Direction.WEST;
		Obstacle obs = new Obstacle(ObsType.TRASH, pos, dir);
		assertEquals(obs.getDirection(), Direction.WEST);
	}
	
	@Test
	public void test11() {
		Position pos = new Position(5, 5);
		Direction dir = Direction.NORTHEAST;
		Obstacle obs = new Obstacle(ObsType.TRASH, pos, dir);
		assertEquals(obs.getDirection(), Direction.NORTHEAST);
	}
	
	@Test
	public void test12() {
		Position pos = new Position(5, 5);
		Direction dir = Direction.NORTHWEST;
		Obstacle obs = new Obstacle(ObsType.TRASH, pos, dir);
		assertEquals(obs.getDirection(), Direction.NORTHWEST);
	}
	
	@Test
	public void test13() {
		Position pos = new Position(5, 5);
		Direction dir = Direction.SOUTHEAST;
		Obstacle obs = new Obstacle(ObsType.TRASH, pos, dir);
		assertEquals(obs.getDirection(), Direction.SOUTHEAST);
	}
	
	@Test
	public void test14() {
		Position pos = new Position(5, 5);
		Direction dir = Direction.SOUTHWEST;
		Obstacle obs = new Obstacle(ObsType.TRASH, pos, dir);
		assertEquals(obs.getDirection(), Direction.SOUTHWEST);
	}
	
}
