package model;

import java.util.ArrayList;

public class ObsCheck {
	
	public boolean willCollide(Obstacle obs, ArrayList<Obstacle> alobs){
		double n1 = obs.getPosition().getY();
		double w1 = obs.getPosition().getX();
		double e1 = w1 + obs.getRenderWidth();//May have to divide 2nd term by size of screen
		double s1 = n1 + obs.getRenderHeight();//May have to divide 2nd term by size of screen
		double n2,w2,e2,s2;
		for(Obstacle obs2 : alobs){
			n2 = obs2.getPosition().getY();
			w2 = obs2.getPosition().getX();
			e2 = w2 + obs2.getRenderWidth();//May have to divide 2nd term by size of screen
			s2 = n2 + obs2.getRenderHeight();//May have to divide 2nd term by size of screen
			if( ((n1>=n2 && n1<=s2) || (n2>=n1 && n2<=s1)) && ((w1>=w2 && w1<=e2) || (w2>=w1 && w2<=e1))){
				return true;
			}
		}
		return false;
	}

}
