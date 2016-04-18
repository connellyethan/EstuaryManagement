package tests;

//import static org.junit.Assert.*;

//import org.junit.Test;

import model.Direction;
import model.ObsType;
import model.Obstacle;
import model.Position;

public class ObsTest {

	//@Test
	public void test0() {
		Position pos = new Position(5, 5);
		Direction dir = Direction.NORTH;
		Obstacle obs = new Obstacle(ObsType.TRASH, pos, dir);
	//	assertEquals(obs.getType(), ObsType.TRASH);

	}

}
