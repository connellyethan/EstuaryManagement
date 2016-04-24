package main;

import java.util.ArrayList;

import model.Direction;
import model.Obstacle;

public abstract class ObsMove {
	public static boolean moveAllObs(ArrayList<Obstacle> list){
		for(Obstacle obs : list){
			while(willCollide(obs, list)){
				obs.setDirection(Direction.getRandom());
			}
			obs.Move();
		}
	}
}
