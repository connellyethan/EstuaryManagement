package main;

import java.util.ArrayList;

import model.Direction;
import model.ObsType;
import model.Obstacle;
import model.Position;

public abstract class ObsFun {

	public static ArrayList<Obstacle> setupObs(int initObs) {
		ArrayList<Obstacle> data = new ArrayList<Obstacle>();
		for (int i = 0; i < initObs; i++) {
			data.add(makeObs());
		}
		return data;
	}

	public static Obstacle makeObs() {
		Position pos = Position.getRandom();
		Direction dir = Direction.getRandom();
		return new Obstacle(ObsType.getRandom(), pos, dir);
	}
	
	public static Obstacle makeObs(ObsType type, Position pos, Direction dir){
		return new Obstacle(type, pos, dir);
	}
/*	
	public static boolean moveAllObs(ArrayList<Obstacle> list) {
		int count;
		for (Obstacle obs : list) {
			count = 0;
			if (obs.getType().getValue() <= 2) { //non-mobile check
				while (willCollide(obs, list) && count < 20) {
					obs.setDirection(Direction.getRandom());
					count++;
				}
				if (count >= 20) { // stop if completely surrounded, or just
									// unlucky
					return true;
				} else {
					obs.move();
					return true;
				}
			}
		}
		return false;
	}

	public static boolean willCollide(Obstacle obs, ArrayList<Obstacle> alobs) {
		double n1 = obs.getPosition().getY();
		double w1 = obs.getPosition().getX();
		double e1 = w1 + obs.getRenderHeight();// may have to divide 2nd term by
												// size of screen
		double s1 = n1 + obs.getRenderHeight();// may have to divide 2nd term by
												// size of screen
		double n2, w2, e2, s2;
		for (Obstacle obs2 : alobs) {
			n2 = obs2.getPosition().getY();
			w2 = obs2.getPosition().getX();
			e2 = w2 + obs2.getRenderHeight();// may have to divide 2nd term by
												// size of screen
			s2 = n2 + obs2.getRenderHeight();// may have to divide 2nd term by
												// size of screen
			if (((n1 >= n2 && n1 <= s2) || (n2 >= n1 && n2 <= s1))
					&& ((w1 >= w2 && w1 <= e2) || (w2 >= w1 && w2 <= e1))) {
				return true;
			}
		}
		return false;
	}
*/
}
